package com.shfc.sms.yunpian;

import com.alibaba.fastjson.JSONObject;
import com.shfc.common.json.JsonUtils;
import com.shfc.sms.JunitBaseTest;
import com.shfc.sms.dto.SmsResultDTO;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import com.yunpian.sdk.model.VoiceSend;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @Package com.shfc.sms.yunpian.YunPianSmsService
 * @Description: 云片短信服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/3 17:11
 * version V1.0.0
 */
public class YunPianSmsServiceTest extends JunitBaseTest {
    @Autowired
    private YunPianSmsService yunPianSmsService;
    @Autowired
    private YunPianVoiceService yunPianVoiceService;
    @Test
    public void testSingleSend(){
        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("apikey","b3c775637042b9db545957222404e884");
        queryMap.put("mobile","13816513175");
        queryMap.put("text","【云片网】您的验证码是185545");
        Result<SmsSingleSend> result =  yunPianSmsService.smsSingleSend(null, null, queryMap);
        System.out.println(result.getCode()+"=="+result.getData()+"=="+result.getDetail()+"=="+result.getMsg());
        Integer code = result.getCode();
        if(code.intValue()==0){
           JSONObject jsonObject = (JSONObject) JSONObject.toJSON(result.getData());
            String count  = jsonObject.getString("count");
        }else {
            System.out.println(result.getCode()+"=="+result.getData()+"=="+result.getDetail()+"=="+result.getMsg());
        }
    }
    @Test
    public void testSingleSendResult(){
        String resultStr  = "{\"code\":0,\"msg\":\"OK\",\"result\":{\"count\":1,\"fee\":0.05,\"sid\":13998194476}}";
        JSONObject object = JsonUtils.parseJavaObject(resultStr,JSONObject.class);
        String code  = object.getString("code");
        String msg  = object.getString("msg");
        String result  = object.getString("result");
        System.out.println(code);
        System.out.println(msg);
        SmsSingleSend singleSend = JsonUtils.parseJavaObject(result,SmsSingleSend.class);
        System.out.println(singleSend.getCount()+"=="+singleSend.getFee()+"=="+singleSend.getUnit()+"=="+singleSend.getSid());
    }
    @Test
    public void testBatchSend(){
        SmsSingleSend singleSend = new SmsSingleSend();
        singleSend.setMobile("13816513170");
        singleSend.setCode(0);
        singleSend.setMsg("发送成功");
        singleSend.setCount(1);
        singleSend.setFee(0.05);
        singleSend.setUnit("RMB");
        singleSend.setSid(3310228968L);
        SmsSingleSend singleSend1 = new SmsSingleSend();
        singleSend1.setMobile("13816513171");
        singleSend1.setCode(0);
        singleSend1.setMsg("发送成功");
        singleSend1.setCount(1);
        singleSend1.setFee(0.05);
        singleSend1.setUnit("RMB");
        singleSend1.setSid(3310228969L);
        List<SmsSingleSend> batchList = new ArrayList<>();
        batchList.add(singleSend);
        batchList.add(singleSend1);

        List<SmsResultDTO> nataveList = new ArrayList<>();
        change(batchList,nataveList);
        System.out.println(nataveList.size());

    }
    public void change(List<SmsSingleSend> batchList,List<SmsResultDTO> nativeList){
        for(Iterator<SmsSingleSend> it = batchList.iterator();it.hasNext();){
            SmsSingleSend singleSend = it.next();
            SmsResultDTO nataveDTO = new SmsResultDTO();
            BeanUtils.copyProperties(singleSend,nataveDTO);
            nativeList.add(nataveDTO);
        }
    }

    /**
     * 发送语音验证码
     * {"code":0,"msg":"成功","data":{"sid":"9f3d7969d5d945548e35c1441f359369","count":"1","fee":0.05}}
     */
    @Test
    public void testVoice(){
        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("mobile","13816513175");
        queryMap.put("code","185545");
        Result<VoiceSend> result = yunPianVoiceService.voiceSend(1L, null, queryMap);
        System.out.println(result.toString());
    }
}
