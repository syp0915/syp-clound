package com.shfc.authentication.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.shfc.authentication.domain.AuthenticationRecord;
import com.shfc.authentication.dto.AuthenticationNameDTO;
import com.shfc.authentication.enums.*;
import com.shfc.authentication.manager.AuthenticationManager;
import com.shfc.authentication.sdk.service.WxService;
import com.shfc.authentication.sdk.wxlink.ApiException;
import com.shfc.authentication.utils.IdentityRemoteUtil;
import com.shfc.authentication.utils.MD5Util;
import com.shfc.authentication.utils.XmlToMap;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.idCard.IdcardValidator;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.math.RandomUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.log.LogFileUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-06 13:58
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Value("${jdwx.appkey}")
    private String appKey;

    @Value("${remote.identity.url}")
    private String identityUrl;

    @Value("${remote.appId}")
    private String appId;

    @Value("${remote.signType}")
    private String signType;

    @Value("${remote.version}")
    private String version;

    @Value("${remote.appSecret}")
    private String appSecret;

    @Autowired
    private WxService wxService;

    @Autowired
    private IdentityRemoteUtil identityRemoteUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    private LogFileUtils logFileUtils=LogFileUtils.getInstance("authentication-provider");
    /**
     * @Description: 身份证实名验证
     * @Title authentication
     * @Author  wuky
     * @Date 2017/3/6 17:17
     * @param  dto
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    @Override
    public ResultDO<Boolean> authenticationByInfo(AuthenticationNameDTO dto) {
        Long startTimeMillis=System.currentTimeMillis();
        ResultDO<Boolean> resultDO = new ResultDO<>();
        Long merchantId = dto.getMerchantId();
        String channelNo=dto.getChannelNo();
        String name = dto.getName();
        String id = dto.getId();
        Integer status =null;

        //参数校验
        ResultDO checkResult=checkParam(dto);
        if(!checkResult.isSuccess()){
            resultDO.setErrMsg(checkResult.getErrMsg());
            resultDO.setErrCode(checkResult.getErrCode());
            return resultDO;
        }

        //身份证校验
        boolean flag = IdcardValidator.isValidatedAllIdcard(id);
        if (!flag) {
            resultDO.setErrCode(AuthenticationErrorCode.ID_CHECK_ERROR.getCode());
            resultDO.setErrMsg(AuthenticationErrorCode.ID_CHECK_ERROR.getMsg());
            return resultDO;
        }
        //
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("idcard", id);
        AuthenticationRecord authenticationRecord = authenticationManager.authenticate(name,id);
        if(authenticationRecord!=null){
            if(authenticationRecord.getStatus()== AuthenticationStatus.SUCCESS.getValue()){
                resultDO.setData(true);
            }else {
                resultDO.setData(false);
                resultDO.setErrMsg("身份证姓名不一致");
            }
            resultDO.setSuccess(true);
            return resultDO;
        }else{
            try {
                String result = wxService.authenticate(merchantId,channelNo,params, appKey);
                Map<String, String> map = JsonUtils.parseJavaObject(result, HashedMap.class);
                String code = map.get("code");
                if (code.equals("10000")) {
                    String resp = map.get("result");
                    Map<String, Object> map1 = XmlToMap.Dom2Map(resp);
                    Object respCode = map1.get("respCode");
                    if ("000".equals(respCode)) {//一致
                        status= AuthenticationStatus.SUCCESS.getValue();
                        resultDO.setData(true);
                        resultDO.setSuccess(true);
                    } else {
                        resultDO.setData(false);
                        if("042".equals(respCode)){//不一致
                            status= AuthenticationStatus.FAIL.getValue();
                            resultDO.setErrMsg("身份证姓名不一致");
                        }else if("121".equals(respCode)){//请求参数错误
                            status=AuthenticationStatus.EXCEPTION.getValue();
                            resultDO.setErrMsg("请正确填写姓名或身份证号码");
                        }else{
                            status= AuthenticationStatus.EXCEPTION.getValue();
                            resultDO.setErrMsg(String.valueOf(map1.get("respDesc")));
                        }
                        resultDO.setSuccess(true);
                    }

                } else {
                    logFileUtils.error("认证模块",merchantId,channelNo,AuthenticationServiceImpl.class,"authenticationByInfo",startTimeMillis);
                    resultDO.setData(false);
                    status= AuthenticationStatus.EXCEPTION.getValue();
                    resultDO.setErrMsg(map.get("msg"));
                }
                authenticationManager.addInfo(dto,status, ChannelType.JDWX.getValue());
                return resultDO;

            } catch ( ApiException e ) {
                logFileUtils.error("认证模块",merchantId,channelNo,AuthenticationServiceImpl.class,"authenticationByInfo",startTimeMillis);
                e.printStackTrace();
                resultDO.setErrCode(AuthenticationErrorCode.JDWX_ERROR.getCode());
                resultDO.setErrMsg(AuthenticationErrorCode.JDWX_ERROR.getMsg());
                return resultDO;
            }
        }

    }

    @Override
    public ResultDO<Boolean> identityId(AuthenticationNameDTO dto) {
        Long startTimeMillis=System.currentTimeMillis();
        ResultDO<Boolean> resultDO = new ResultDO<>();
        Long merchantId = dto.getMerchantId();
        String channelNo=dto.getChannelNo();
        String name = dto.getName();
        String id = dto.getId();
        Integer status =null;

        //参数校验
        ResultDO checkResult=checkParam(dto);
        if(!checkResult.isSuccess()){
            resultDO.setErrMsg(checkResult.getErrMsg());
            resultDO.setErrCode(checkResult.getErrCode());
            return resultDO;
        }

        //身份证号码简单规则校验
        boolean flag = IdcardValidator.isValidatedAllIdcard(dto.getId());
        if (!flag) {
            resultDO.setErrCode(AuthenticationErrorCode.ID_CHECK_ERROR.getCode());
            resultDO.setErrMsg(AuthenticationErrorCode.ID_CHECK_ERROR.getMsg());
            return resultDO;
        }

        AuthenticationRecord authenticationRecord = authenticationManager.authenticate(name,id);
        if(authenticationRecord!=null) {
            if (authenticationRecord.getStatus() == AuthenticationStatus.SUCCESS.getValue()) {
                resultDO.setData(true);
            } else {
                resultDO.setData(false);
                resultDO.setErrMsg("身份证姓名不一致");
            }
            resultDO.setSuccess(true);
            return resultDO;
        }else {
            Map<String,String> map=new HashMap<>();
            map.put("authType", AuthType.NO_PHOTO.getName());//不返照认证
            map.put("thirdPartTrans", startTimeMillis + RandomUtils.generateNumberString(20));//交易流水,时间+20位长度的随机数
            map.put("source", "DTSFRZ");
            map.put("name", name);
            map.put("identityNo", id);
            map.put("acceptChannel",appId);
            String params = new Gson().toJson(map);

            HashMap<String, String> paramMap = new HashMap<>();
            String signCode = MD5Util.getSignCode(appId, version, signType, params, appSecret);
            paramMap.put("appId", appId);
            paramMap.put("version", version);
            paramMap.put("signType", signType);
            paramMap.put("signCode", signCode);
            paramMap.put("params", params);
            System.out.println(new Gson().toJson(paramMap));
            String resp = identityRemoteUtil.createRequest(merchantId,channelNo,identityUrl, paramMap);
            //String resp="{\"remark\":\"\",\"resMessage\":\"\",\"resStatus\":\"80001200001\",\"result\":[{\"backIamge\":[],\"identityNo\":\"321281199112311715\",\"name\":\"吴开阳\",\"platformTrans\":\"\",\"rate\":\"\",\"result\":\"0001\",\"resultMsg\":\"认证不一致\"}]}";
            logFileUtils.info("认证宝身份认证返回结果" + resp);

            JSONObject jsonObject=JsonUtils.parseJavaObject(resp,JSONObject.class);
            if(jsonObject.getString("resStatus").equals(ResStatus.SUCCESS.getValue())){//响应码 80001200001:成功

                JSONArray array=jsonObject.getJSONArray("result");
                logFileUtils.info("json解析result" + array);
                JSONObject object=(JSONObject)array.get(0);
                String result=object.getString("result");
                String resultMsg=object.getString("resultMsg");
                if(result.equals(ResultStatus.SUCCESS.getValue())){//认证通过
                    status=AuthenticationStatus.SUCCESS.getValue();
                    resultDO.setData(true);
                }
                if(result.equals(ResultStatus.FAIL.getValue())){//认证不一致
                    status=AuthenticationStatus.FAIL.getValue();
                    resultDO.setData(false);
                    resultDO.setErrMsg(resultMsg);
                }
                if(result.equals(ResultStatus.EXCEPTION.getValue())){//交易异常
                    status=AuthenticationStatus.EXCEPTION.getValue();
                    resultDO.setData(false);
                    resultDO.setErrMsg(resultMsg);
                }
                if(result.equals(ResultStatus.PROCESSING.getValue())){//正在处理中
                    status=AuthenticationStatus.PROCESSING.getValue();
                    resultDO.setData(false);
                    resultDO.setErrMsg(resultMsg);
                }
                resultDO.setSuccess(true);
                //保存记录
                authenticationManager.addInfo(dto,status, ChannelType.RZB.getValue());

            }else {
                //认证宝出现调用http接口异常直接返回认证成功
                if(jsonObject.getString("resStatus").equals("800014500002")){
                    resultDO.setSuccess(true);
                    resultDO.setData(true);
                }else {
                    String resMessage = jsonObject.getString("resMessage");
                    resultDO.setErrMsg(resMessage);
                    resultDO.setSuccess(false);
                }

            }
        }
        return resultDO;
    }


    public ResultDO checkParam(AuthenticationNameDTO dto){
        ResultDO resultDO=new ResultDO();

        if(dto.getMerchantId()==null){
            resultDO.setErrCode(AuthenticationErrorCode.MERCHANTID_NOT_NULL.getCode());
            resultDO.setErrMsg(AuthenticationErrorCode.MERCHANTID_NOT_NULL.getMsg());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(dto.getChannelNo())){
            resultDO.setErrCode(AuthenticationErrorCode.CHANNELNO_NOT_NULL.getCode());
            resultDO.setErrMsg(AuthenticationErrorCode.CHANNELNO_NOT_NULL.getMsg());
            return resultDO;
        }
        if (ValidateHelper.isEmpty(dto.getName())) {
            resultDO.setErrCode(AuthenticationErrorCode.NAME_NOT_NULL.getCode());
            resultDO.setErrMsg(AuthenticationErrorCode.NAME_NOT_NULL.getMsg());
            return resultDO;
        }
        if(ValidateHelper.isEmpty(dto.getId())){
            resultDO.setErrCode(AuthenticationErrorCode.ID_NOT_NULL.getCode());
            resultDO.setErrMsg(AuthenticationErrorCode.ID_NOT_NULL.getMsg());
            return resultDO;
        }
        resultDO.setSuccess(true);
        return resultDO;
    }





}
