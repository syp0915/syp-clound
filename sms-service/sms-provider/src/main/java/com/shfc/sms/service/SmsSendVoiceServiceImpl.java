package com.shfc.sms.service;

import com.shfc.common.base.RegexUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.sms.domain.SmsVoice;
import com.shfc.sms.dto.SendVoiceDTO;
import com.shfc.sms.dto.VoiceResultDTO;
import com.shfc.sms.enums.ChannelType;
import com.shfc.sms.enums.SmsErrorCode;
import com.shfc.sms.enums.SmsLogStatus;
import com.shfc.sms.manager.SmsRecordManager;
import com.shfc.sms.yunpian.YunPianVoiceService;
import com.yunpian.sdk.constant.YunpianConstant;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.VoiceSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.shfc.sms.service.SmsSendVoiceServiceImpl
 * @Description: 语音发送
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/1 14:45
 * version V1.0.0
 */
@Service
public class SmsSendVoiceServiceImpl implements SmsSendVoiceService {
    private static final Logger logger =Logger.getLogger(SmsSendVoiceServiceImpl.class);

    @Autowired
    private YunPianVoiceService yunPianVoiceService;
    @Autowired
    private SmsRecordManager smsRecordManager;
    @Override
    public ResultDO<VoiceResultDTO> sendVoice(SendVoiceDTO sendVoiceDTO) {
        ResultDO<VoiceResultDTO> resultDO = new ResultDO<>();
        String mobile = sendVoiceDTO.getMobile();
        String code = sendVoiceDTO.getCode();
        Long merchantId = sendVoiceDTO.getMerchantId();//商户id
        String checkParam = checkSendVoice(merchantId,mobile,code);
        if(checkParam!=null){
            resultDO.setErrCode(SmsErrorCode.getValueByName(checkParam));
            resultDO.setErrMsg(checkParam);
            return resultDO;
        }
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put(YunpianConstant.MOBILE,mobile);
        queryMap.put(YunpianConstant.CODE,code);
        Result<VoiceSend> voiceRresult = yunPianVoiceService.voiceSend(merchantId, sendVoiceDTO.getChannelNo(), queryMap);
        logger.info("sendVoice==="+voiceRresult.toString());
        if(voiceRresult.getCode().intValue()!=0){
            resultDO.setErrCode(SmsErrorCode.SMS_OPERATOR_ERROR.getCode());
            resultDO.setErrMsg(voiceRresult.getMsg());
            return resultDO;
        }else {
            VoiceSend voiceSend = voiceRresult.getData();
            SmsVoice record = new SmsVoice();
            record.setMerchantId(merchantId);//商户id
            record.setMobile(mobile);//手机号
            record.setSmsCode(code);//验证码code
            record.setSendStatus(SmsLogStatus.SUCCESS.getValue());//发送状态
            record.setSmsFee(BigDecimal.valueOf(voiceSend.getFee()));//语音通道收取费用
            record.setSendCount(Integer.parseInt(voiceSend.getCount()));//成功发送的语音呼叫次数
            record.setSid(voiceSend.getSid());//短信id
            record.setChannel(ChannelType.YUNPIAN.getValue());//短信通道(0-云片).
            record.setCreater(merchantId);
            try {
                smsRecordManager.insertSmsVoice(record);
            } catch (AppException e) {
                logger.error( "语音验证码插入异常" , e);
            }
            VoiceResultDTO voiceResultDTO = new VoiceResultDTO();
            voiceResultDTO.setSid(voiceSend.getSid());
            voiceResultDTO.setCount(voiceSend.getCount());
            resultDO.setData(voiceResultDTO);
            resultDO.setSuccess(true);
            return resultDO;
        }
    }
    /**
     * 单条发送入参校验
     * @param mobile
     * @param code
     * @return
     */
    private String checkSendVoice(Long merchantId ,String mobile,String code){
        if(merchantId==null ||  ValidateHelper.isEmptyString(mobile) || ValidateHelper.isEmptyString(code)){
            return SmsErrorCode.PARAMETER_NOT_NULL.getMsg();
        }
        if(!RegexUtils.isMobile(mobile)){
            return SmsErrorCode.PHONE_FORMAT_ERROR.getMsg();
        }

       /* if(ValidateHelper.isEmptyString(code)){
            return "语音验证码不能为空！";
        }*/
        if(code.length()>6 || !RegexUtils.isInteger(code)){
            return SmsErrorCode.VOICE_LENGTH_ERROR.getMsg();
        }
        return null;
    }
}
