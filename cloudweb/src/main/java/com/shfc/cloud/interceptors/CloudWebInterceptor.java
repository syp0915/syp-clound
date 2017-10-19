package com.shfc.cloud.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.account.domain.MerchantApikey;
import com.shfc.cloud.account.service.AccountService;
import com.shfc.cloud.constant.CloudConstant;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.exception.CloudWebException;
import com.shfc.cloud.utils.HttpSessionUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.encrypt.AESUtils;
import com.shfc.common.result.ResultDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

/**
 * @Package com.shfc.cloud.interceptors.CloudWebInterceptor
 * @Description: CloudWebInterceptor
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/15 8:53
 * version V1.0.0
 */
@Slf4j
public class CloudWebInterceptor extends HandlerInterceptorAdapter {

    // 拦截器开启标志
    @Value("${request.interceptor.openLogo}")
    private boolean openLogo = false;
    @Value("${cloud.web.version}")
    private String cloudWebVersion;
    @Value("${php.channel.no}")
    private String phpChannelNo;
    @Autowired
    private AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        String uri = request.getRequestURI();
        if (!uri.endsWith(cloudWebVersion)) {
            throw new CloudWebException(ErrorConstant.ERROR_VERSION.getCode(),
                    ErrorConstant.ERROR_VERSION.getMsg());
        }

        if (openLogo) {
            // 判断是否为json 请求
            String contentType = request.getContentType();
            if (!MediaType.APPLICATION_JSON_UTF8_VALUE.contains(contentType)) {
                throw new CloudWebException(ErrorConstant.ERROR_MEDIA_TYPE.getCode(),
                        ErrorConstant.ERROR_MEDIA_TYPE.getMsg());
            }
            // 内容长度
            int contentLength = request.getContentLength();

            if (contentLength == 0) {
                throw new CloudWebException(ErrorConstant.EMPTY_REQUEST_BOYD.getCode(),
                        ErrorConstant.EMPTY_REQUEST_BOYD.getMsg());
            }

            if (request instanceof BodyReaderHttpServletRequestWrapper) {
                BodyReaderHttpServletRequestWrapper requestWrapper = (BodyReaderHttpServletRequestWrapper) request;
                // 请求body不为空
                BufferedReader reader = requestWrapper.getReader();
                StringBuilder sb = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                JSONObject body = null;
                try {
                    body = JSON.parseObject(sb.toString());
                }catch (Exception e){
                    throw new CloudWebException(ErrorConstant.ERROR_REQUEST_BOYD.getCode(),
                            ErrorConstant.ERROR_REQUEST_BOYD.getMsg());
                }
                String apiKey = body.getString(CloudConstant.API_KEY);
                String reqJson = body.getString(CloudConstant.REQ_JSON);
                String timestamp = body.getString(CloudConstant.TIMESTAMP);
                String signature = body.getString(CloudConstant.SIGNATURE);

                requestWrapper.setBody(reqJson.getBytes("UTF-8"));
                // 验签接口
                // step 1 请求路径判断是否合法 需要拦截
                // step 2 获取请求参数判断值是否合法 - 参数1、apiKey(身份标识), 2、reqJson(请求参数)、3、timestamp（时间戳） 4、signature(签名内容)
                // step 3 验签

                if (ValidateHelper.isEmpty(apiKey)) {
                    // api key
                    throw new CloudWebException(ErrorConstant.NULL_API_KEY.getCode(),
                            ErrorConstant.NULL_API_KEY.getMsg());
                }
                log.info("查询商户信息start");
                ResultDO<MerchantApikey> resultDO = accountService.apikeyInfo(apiKey);
                if(!resultDO.isSuccess()){
                    throw new CloudWebException(resultDO.getErrCode(),
                            resultDO.getErrMsg());
                }
                MerchantApikey merchantApikey = resultDO.getData();
                if(merchantApikey == null){
                    throw new CloudWebException(ErrorConstant.INVALID_MERCHANT.getCode(),
                            ErrorConstant.INVALID_MERCHANT.getMsg());
                }
                // 商户秘钥---可以根据请求参数内的apiKey到数据库获取商户的加签秘钥
                String encryptKey = merchantApikey.getEncrypKey();
                log.info("encryptKey:{}",encryptKey);
                HttpSessionUtils.putObject(CloudConstant.CURRENT_ACCESS_KEY, encryptKey);
                if (ValidateHelper.isEmpty(reqJson)) {
                    // reqJson - 请求参数
                    throw new CloudWebException(ErrorConstant.NULL_REQ_JSON.getCode(),
                            ErrorConstant.NULL_REQ_JSON.getMsg());
                }

                if (ValidateHelper.isEmpty(timestamp)) {
                    // timestamp - 时间戳
                    throw new CloudWebException(ErrorConstant.NULL_TIMESTAMP.getCode(),
                            ErrorConstant.NULL_TIMESTAMP.getMsg());
                }

                if (ValidateHelper.isEmpty(signature)) {
                    // signature - 签名内容
                    throw new CloudWebException(ErrorConstant.NULL_SIGNATURE.getCode(),
                            ErrorConstant.NULL_SIGNATURE.getMsg());
                }

                String verifyObject = "";
                try {
                    // 解密数据
                    log.info("signature:{},encryptKey:{},timestamp:{}",signature,encryptKey,timestamp);
                    String verifySign = AESUtils.decrypt(signature, encryptKey, timestamp);
                    log.info("verifySign:{}",verifySign);
                    // 解密数据转换成对象
                    JSONObject jsonObject = JSON.parseObject(verifySign);
                    // 解密数据转换成字符串
                    verifyObject = jsonObject.toJSONString();
                    log.info("verifyObject:{}",verifyObject);
                }catch (Exception e){
                    // 加签失败
                    throw new CloudWebException(ErrorConstant.ERROR_SIGNATURE.getCode(),
                            ErrorConstant.ERROR_SIGNATURE.getMsg(), e);
                }
                // 请求数据转换
               // String requestJson = JSON.parseObject(reqJson).toJSONString();
                if(verifyObject.equals(reqJson)) {
                    // 验签成功
                    HttpSessionUtils.putObject(CloudConstant.CURRENT_MERCHANT_ID, merchantApikey.getMerchantId());
                    HttpSessionUtils.putObject(CloudConstant.CURRENT_CHANNEL_NO, phpChannelNo);

                    return true;
                } else {
                    // 验签失败
                    throw new CloudWebException(ErrorConstant.VERIFY_SIGNATURE_FAILED.getCode(),
                            ErrorConstant.VERIFY_SIGNATURE_FAILED.getMsg());
                }
            }
        } else {
            BodyReaderHttpServletRequestWrapper requestWrapper = (BodyReaderHttpServletRequestWrapper) request;
            // 请求body不为空
            BufferedReader reader = requestWrapper.getReader();
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONObject body = null;
            body = JSON.parseObject(sb.toString());
            String reqJson = body.getString(CloudConstant.REQ_JSON);
            requestWrapper.setBody(reqJson.getBytes());
            // 开发联调时免验签
            HttpSessionUtils.putObject(CloudConstant.CURRENT_ACCESS_KEY, "a6b9e216b8be4a37bd9e9aee92ef5bb8");
            HttpSessionUtils.putObject(CloudConstant.CURRENT_MERCHANT_ID, 1L);
            HttpSessionUtils.putObject(CloudConstant.CURRENT_CHANNEL_NO, "NO001");
        }

        return true;
    }
}
