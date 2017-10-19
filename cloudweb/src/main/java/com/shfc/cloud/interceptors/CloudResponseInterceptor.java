package com.shfc.cloud.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.constant.CloudConstant;
import com.shfc.cloud.utils.HttpSessionUtils;
import com.shfc.common.base.Logger;
import com.shfc.common.encrypt.AESUtils;
import com.shfc.common.result.ResultDO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Package com.shfc.cloud.interceptors.CloudResponseInterceptor
 * @Description: 统一响应结果处理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/17 10:45
 * version V1.0.0
 */
@ControllerAdvice
public class CloudResponseInterceptor implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 响应结果执行
        if(mediaType != null && o != null
                && mediaType.includes(MediaType.APPLICATION_JSON)
                && o instanceof ResultDO){
            // application/json 返回类型  处理

            // 商户秘钥---可以根据请求参数内的apiKey到数据库获取商户的加签秘钥
            String encryptKey = HttpSessionUtils.getObject(CloudConstant.CURRENT_ACCESS_KEY);

            // 响应结果
            String respJson = JSON.toJSONString(o);
            // 时间戳
            String timestamp = String.valueOf(System.currentTimeMillis());
            try {
                String signature = AESUtils.encrypt(respJson, encryptKey, timestamp);
                JSONObject result = new JSONObject();
                result.put(CloudConstant.RESP_JSON, respJson);
                result.put(CloudConstant.TIMESTAMP, timestamp);
                result.put(CloudConstant.SIGNATURE, signature);

                return result;
            } catch (Exception e) {
                Logger.error(CloudResponseInterceptor.class, "响应结果加签失败", e);
            }
        }

        return o;
    }
}
