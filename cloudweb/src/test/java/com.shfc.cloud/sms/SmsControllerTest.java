package com.shfc.cloud.sms;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.JunitBaseMockMvcTest;
import com.shfc.cloud.sms.dto.SendSmsWebDTO;
import com.shfc.cloud.sms.dto.SmsTplWebDTO;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.sms.SmsControllerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/1 17:39
 * version V1.0.0
 */
public class SmsControllerTest extends JunitBaseMockMvcTest {
    @Test
    public void testSingleSend() throws Exception{
        SendSmsWebDTO webDTO = new SendSmsWebDTO();
        webDTO.setMerchantId(1L);
        webDTO.setChannelNo("999");
        webDTO.setTemplateId(10L);
        //webDTO.setMobile("13816513175");
        webDTO.setText("经纪人张三丰接受了您的房源委托请求.");
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/singleSend/v1.0.0";
        mockMvc(postStr,reqJson);
    }

    @Test
    public void testBatchSend() throws Exception{
        SendSmsWebDTO webDTO = new SendSmsWebDTO();
        webDTO.setMerchantId(1L);
        webDTO.setChannelNo("999");
        webDTO.setTemplateId(10L);
        //webDTO.setMobile("13816513175,13816513176");
        webDTO.setText("经纪人张三丰接受了您的房源委托请求.");
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/batchSend/v1.0.0";
        mockMvc(postStr,reqJson);
    }

    @Test
    public void testMultiSend() throws Exception{
        SendSmsWebDTO webDTO = new SendSmsWebDTO();
        webDTO.setMerchantId(1L);
        webDTO.setChannelNo("999");
        webDTO.setTemplateId(10L);
        //webDTO.setMobile("13816513175,13816513176");
        webDTO.setText("【上海有房网】经纪人张三丰接受了您的房源委托请求.,【上海有房网】经纪人张三丰接受了您的房源委托请求.");
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/multiSend/v1.0.0";
        mockMvc(postStr,reqJson);
    }
    public void mockMvc(String postStr ,String reqJson) throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post(postStr).content(reqJson).contentType(MediaType.APPLICATION_JSON)
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
