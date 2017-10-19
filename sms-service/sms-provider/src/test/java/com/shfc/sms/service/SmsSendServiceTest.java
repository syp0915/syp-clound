package com.shfc.sms.service;

import com.alibaba.fastjson.JSONObject;
import com.shfc.common.result.ResultDO;
import com.shfc.sms.JunitBaseTest;
import com.shfc.sms.dto.*;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsBatchSend;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Package com.shfc.sms.service.SmsSendServiceTest
 * @Description: 短信service测试类
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/6 14:27
 * version V1.0.0
 */
public class SmsSendServiceTest extends JunitBaseTest {
    @Autowired
    private SmsSendService smsSendService;
    @Autowired
    private SmsSendVoiceService smsSendVoiceService;
    @Test
    public void  testSingleSend(){
        SendSmsDTO sendSmsDTO = new SendSmsDTO();
        sendSmsDTO.setTemplateId(1L);
        sendSmsDTO.setMerchantId(2L);
        sendSmsDTO.setChannelNo("999");
        sendSmsDTO.setMobile("13816513175");
        sendSmsDTO.setText("【东方物流】您的订单编号是123999");
        ResultDO<SmsResultDTO> resultDO =  smsSendService.singleSend(sendSmsDTO);
        System.out.println("resultDO=="+resultDO.toString());
    }

    @Test
    public void testBatchSend(){
        SendSmsDTO sendSmsDTO = new SendSmsDTO();
        sendSmsDTO.setTemplateId(1L);
        sendSmsDTO.setMerchantId(2L);
        sendSmsDTO.setChannelNo("996");
        sendSmsDTO.setMobile("13816513175,17602103861,18993123900");
        sendSmsDTO.setText("【云片网】您的验证码是308800");
        ResultDO<SmsBatchResultDTO> resultDO = smsSendService.batchSend(sendSmsDTO);
        System.out.println(resultDO.toString());
    }

    @Test
    public void testMultiSend(){
        SendSmsDTO sendSmsDTO = new SendSmsDTO();
        sendSmsDTO.setTemplateId(1L);
        sendSmsDTO.setMerchantId(1L);
        sendSmsDTO.setChannelNo("998");
        sendSmsDTO.setMobile("13000000000,13000000001,13000000002,13000000000");
        sendSmsDTO.setText("【云片网】您的验证码是308281,【云片网】您的验证码是308282,【云片网】您的验证码是308283,【云片网】您的验证码是308281");
        ResultDO<SmsBatchResultDTO> resultDO = smsSendService.multiSend(sendSmsDTO);
        System.out.println(resultDO.toString());
    }
    @Test
    public void testVoiceSms(){
        SendVoiceDTO sendVoiceDTO = new SendVoiceDTO();
        sendVoiceDTO.setTemplateId(1L);
        sendVoiceDTO.setMerchantId(1L);
        sendVoiceDTO.setMobile("13816513175");
        sendVoiceDTO.setCode("16092i");
        ResultDO<VoiceResultDTO> resultDO = smsSendVoiceService.sendVoice(sendVoiceDTO);
        System.out.println(resultDO);
    }
    @Test
    public void testResult(){
        String str= "{\"total_count\":2,\"total_fee\":\"0.2000\",\"unit\":\"RMB\",\"data\":[{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000000\",\"sid\":3310228964},{\"code\":0,\"msg\":\"发送成功\",\"count\":1,\"fee\":0.05,\"unit\":\"RMB\",\"mobile\":\"13000000001\",\"sid\":3310228968}]}";
        Result<SmsBatchSend> result = new Result<>() ;
        SmsBatchSend record  = JSONObject.parseObject(str, SmsBatchSend.class);
        result.setData(record);
        System.out.println("result.toString()=="+result);
    }
}
