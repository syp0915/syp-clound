package com.shfc.cloud.sms;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.JunitBaseMockMvcTest;
import com.shfc.cloud.sms.dto.SmsSignWebDTO;
import com.shfc.cloud.sms.dto.SmsTplWebDTO;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.sms.TempleControllerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/1 17:10
 * version V1.0.0
 */
public class TempleControllerTest extends JunitBaseMockMvcTest {
    @Test
    public void testAddTemplate() throws Exception{
        SmsTplWebDTO webDTO = new SmsTplWebDTO();
        webDTO.setMerchantId(21L);
        webDTO.setChannelNo("998");
        webDTO.setSignId(222L);
        webDTO.setTplContent("经纪人#name#接受了您的房源委托请求。");
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/addTemplate/v1.0.0";
        mockMvc(postStr,reqJson);
    }

    @Test
    public void testGetTemplate() throws Exception{
        SmsTplWebDTO webDTO = new SmsTplWebDTO();
        webDTO.setMerchantId(1L);
        webDTO.setChannelNo("998");
        webDTO.setTplId(10L);
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/getTemplate/v1.0.0";
        mockMvc(postStr,reqJson);
    }

    @Test
    public void testUpdateTemplate() throws Exception{
        SmsTplWebDTO webDTO = new SmsTplWebDTO();
        webDTO.setMerchantId(1L);
        webDTO.setChannelNo("998");
        webDTO.setTplId(10L);
        webDTO.setSignId(15L);
        webDTO.setTplContent("经纪人#name#接受了您的房源委托请求.");
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/updateTemplate/v1.0.0";
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
