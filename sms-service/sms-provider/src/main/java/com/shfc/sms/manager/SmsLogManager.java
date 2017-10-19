package com.shfc.sms.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.common.base.Logger;
import com.shfc.sms.dao.SmsLogMapper;
import com.shfc.sms.domain.SmsLog;
import com.shfc.sms.enums.ChannelType;
import com.shfc.sms.enums.SmsLogStatus;
import com.shfc.sms.enums.SmsLogType;
import com.shfc.sms.yunpian.YunPianSignService;
import com.shfc.sms.yunpian.YunPianSmsService;
import com.shfc.sms.yunpian.YunPianTemplateService;
import com.shfc.sms.yunpian.YunPianVoiceService;
import com.yunpian.sdk.constant.Code;
import com.yunpian.sdk.constant.YunpianConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.sms.manager.SmsLogManager
 * @Description: 日志收集
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:43
 * version V1.0.0
 */
@Service
public class SmsLogManager {
    @Autowired
    private SmsLogMapper smsLogMapper;

    @Async
    public void saveLog(Long merchantId, String channelNo,SmsLogType type,
                        Object reqContent, String jsonResp, SmsLogStatus smsLogStatus){

        SmsLog log = new SmsLog();
        log.setMerchantId(merchantId);
        log.setChannelNo(channelNo);
        log.setChannel(ChannelType.YUNPIAN.getValue());
        log.setReqType(type.getValue());
        log.setReqContent(JSON.toJSONString(reqContent));
        log.setRespContent(jsonResp);
        log.setStatus(smsLogStatus.getValue());
        log.setCreater(merchantId);

        try {
            smsLogMapper.insert(log);
        }catch (Exception e){
            Logger.error(SmsLogManager.class, "保存日志异常", e);
        }
    }

    @Async
    public void collectingLogs(Object clazz, String methodName, Object[] args, Object returnValue){

        SmsLogType smsLogType = SmsLogType.UNKNOWN;

        SmsLogStatus smsLogStatus = SmsLogStatus.EXCEPTION;

        String jsonResp = null;

        if(returnValue != null){
            try {
                jsonResp = JSON.toJSONString(returnValue);
                JSONObject jsonObject = JSONObject.parseObject(jsonResp);
                Integer code = jsonObject.getInteger(YunpianConstant.CODE);
                if(code.intValue() == Code.OK){
                    smsLogStatus = SmsLogStatus.SUCCESS;
                }else{
                    smsLogStatus = SmsLogStatus.FAILED;
                }
            }catch (Exception e){
                Logger.error(SmsLogManager.class, "json对象转换异常", e);
            }
        }

        if(clazz instanceof YunPianSignService){
            smsLogType = SmsLogType.SIGN;
        }
        else if(clazz instanceof YunPianTemplateService){
            smsLogType = SmsLogType.TEMPLATE;
        }
        else if(clazz instanceof YunPianSmsService){
            if("smsSingleSend".equals(methodName)){
                smsLogType = SmsLogType.SINGLE_SEND;
            }else if("smsBatchSend".equals(methodName)){
                smsLogType = SmsLogType.BATCH_SEND;
            }else if("smsMultiSend".equals(methodName)){
                smsLogType = SmsLogType.MULTI_SEND;
            }
        }
        else if(clazz instanceof YunPianVoiceService){
            smsLogType = SmsLogType.VOICE_SEND;
        }

        try{
            saveLog((Long)args[0],(String)args[1], smsLogType, args[2], jsonResp, smsLogStatus);
        }catch (Exception e){
            Logger.error(SmsLogManager.class, "保存日志异常", e);
        }

    }
}
