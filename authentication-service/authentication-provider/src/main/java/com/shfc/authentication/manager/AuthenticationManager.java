package com.shfc.authentication.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shfc.authentication.dao.AuthenticationLogMapper;
import com.shfc.authentication.dao.AuthenticationRecordMapper;
import com.shfc.authentication.domain.AuthenticationLog;
import com.shfc.authentication.domain.AuthenticationRecord;
import com.shfc.authentication.dto.AuthenticationNameDTO;
import com.shfc.authentication.enums.*;
import com.shfc.authentication.utils.XmlToMap;
import com.shfc.common.base.Logger;
import com.shfc.common.idCard.IdcardInfoExtractor;
import com.shfc.common.json.JsonUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-09 10:47
 **/
@Service
public class AuthenticationManager {
    @Autowired
    private AuthenticationLogMapper logMapper;
    @Autowired
    private AuthenticationRecordMapper authenticationRecordMapper;


    public AuthenticationRecord authenticate(String name,String id){
        return authenticationRecordMapper.authenticate(name,id);
    }
    /**
     * @Description: 身份证实名验证通过后保存
     * @Title authentication
     * @Author  wuky
     * @Date 2017/3/9 17:17
     * @param  dto
     * @return void
     * @throws
     */
    public void addInfo(AuthenticationNameDTO dto,Integer status,Integer channel){
        AuthenticationRecord record=new AuthenticationRecord();
        IdcardInfoExtractor idcardInfoExtractor=new IdcardInfoExtractor(dto.getId());
        record.setMerchantId(dto.getMerchantId());
        record.setChannelNo(dto.getChannelNo());
        record.setName(dto.getName());
        record.setIdcard(dto.getId());
        record.setProvinceId(Long.valueOf(idcardInfoExtractor.getProvinceId()));
        record.setSex(GenderType.getValueByName(idcardInfoExtractor.getGender()));
        record.setProvince(idcardInfoExtractor.getProvince());
        record.setStatus(status);
        record.setChannel(channel);
        record.setCreater(dto.getMerchantId());
        try {
            authenticationRecordMapper.insert(record);
        }catch ( Exception e ){
            Logger.error(AuthenticationLogMapper.class, AuthenticationErrorCode.RECORD_ERROR.getMsg(), e);
        }
    }


    /**
     * @Description: 日志收集
     * @Title collectingLogs
     * @Author  wuky
     * @Date 2017/3/9 17:17
     * @return void
     * @throws
     */
    @Async
    public void collectingLogs(Object clazz, String methodName, Object[] args, Object returnValue){

        AuthenticationStatus authenticationStatus = AuthenticationStatus.EXCEPTION;
        if(returnValue != null){
            try {
                String result=returnValue.toString();
                Map<String,String> map= JsonUtils.parseJavaObject(result, HashedMap.class);
                String code=map.get("code");
                if(code.equals("10000")){
                    String resp=map.get("result");
                    Map<String,Object> map1= XmlToMap.Dom2Map(resp);
                    Object respCode=map1.get("respCode");
                    if("000".equals(respCode)){//一致
                        authenticationStatus = AuthenticationStatus.SUCCESS;
                    }else if("042".equals(respCode)){//不一致
                        authenticationStatus = AuthenticationStatus.FAIL;
                    }

                }else{
                    authenticationStatus = AuthenticationStatus.EXCEPTION;
                }

            }catch (Exception e){
                Logger.error(AuthenticationManager.class, AuthenticationErrorCode.JSON_EXCEPTION.getMsg(), e);
            }
        }



        try{
            saveLog((Long)args[0], (String)args[1],args[2], returnValue.toString(), authenticationStatus,ChannelType.JDWX.getValue());
        }catch (Exception e){
            Logger.error(AuthenticationManager.class, AuthenticationErrorCode.RECORD_ERROR.getMsg(), e);
        }

    }



    /**
     * @Description: 日志收集
     * @Title collectingLogs
     * @Author  wuky
     * @Date 2017/3/9 17:17
     * @return void
     * @throws
     */
    @Async
    public void rzbAddLogs(Object clazz, String methodName, Object[] args, Object returnValue){

        AuthenticationStatus authenticationStatus = AuthenticationStatus.EXCEPTION;
        if(returnValue != null){
            String resp=String.valueOf(returnValue);
            try {
                JSONObject jsonObject = JsonUtils.parseJavaObject(resp, JSONObject.class);
                if (jsonObject.getString("resStatus").equals(ResStatus.SUCCESS.getValue())) {//响应码 80001200001:成功
                    JSONArray array = jsonObject.getJSONArray("result");
                    JSONObject object = (JSONObject) array.get(0);
                    String result = object.getString("result");
                    String resultMsg = object.getString("resultMsg");
                    if (result.equals(ResultStatus.SUCCESS.getValue())) {//认证通过
                        authenticationStatus = AuthenticationStatus.SUCCESS;
                    }
                    if (result.equals(ResultStatus.FAIL.getValue())) {//认证不一致
                        authenticationStatus = AuthenticationStatus.FAIL;

                    }
                    if (result.equals(ResultStatus.EXCEPTION.getValue())) {//交易异常
                        authenticationStatus = AuthenticationStatus.EXCEPTION;

                    }
                    if (result.equals(ResultStatus.PROCESSING.getValue())) {//正在处理中
                        authenticationStatus = AuthenticationStatus.PROCESSING;

                    }

                }
            }catch ( Exception e ){
                Logger.error(AuthenticationManager.class, AuthenticationErrorCode.JSON_EXCEPTION.getMsg(), e);
            }


        }

        try{
            saveLog((Long)args[0], (String)args[1],args[3], returnValue.toString(), authenticationStatus,ChannelType.RZB.getValue());
        }catch (Exception e){
            Logger.error(AuthenticationManager.class, AuthenticationErrorCode.RECORD_ERROR.getMsg(), e);
        }

    }

    @Async
    public void saveLog(Long merchantId,String channelNo,
                        Object reqContent, String jsonResp, AuthenticationStatus authenticationStatus,Integer channel){

        AuthenticationLog log=new AuthenticationLog();
        log.setMerchantId(merchantId);
        log.setChannelNo(channelNo);
        log.setChannel(channel);
        log.setReqContent(JSON.toJSONString(reqContent));
        log.setRespContent(jsonResp);
        log.setStatus(authenticationStatus.getValue());
        log.setCreater(merchantId);


        try {
            logMapper.insert(log);
        }catch (Exception e){
            Logger.error(AuthenticationLog.class, AuthenticationErrorCode.RECORD_ERROR.getMsg(), e);
        }
    }
}
