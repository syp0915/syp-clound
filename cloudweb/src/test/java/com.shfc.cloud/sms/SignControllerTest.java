package com.shfc.cloud.sms;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.JunitBaseMockMvcTest;
import com.shfc.cloud.sms.dto.SmsSignWebDTO;
import com.shfc.common.json.JsonUtils;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.sms.SignControllerTest
 * @Description: 签名的测试代码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/1 15:44
 * version V1.0.0
 */
public class SignControllerTest extends JunitBaseMockMvcTest {
    @Test
    public void testAddSign() throws Exception{
        SmsSignWebDTO webDTO = new SmsSignWebDTO();
        webDTO.setMerchantId(21L);
        webDTO.setChannelNo("998");
        webDTO.setSign("【东方金融】");
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/addSign/v1.0.0";
        mockMvc(postStr,reqJson);
    }

    @Test
    public void testGetSignById() throws Exception{
        SmsSignWebDTO webDTO = new SmsSignWebDTO();
        webDTO.setMerchantId(21L);
        webDTO.setChannelNo("998");
        webDTO.setSignId(1L);
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/getSignById/v1.0.0";
        mockMvc(postStr,reqJson);
    }
    @Test
    public void  testUpdateSign()throws Exception {
        SmsSignWebDTO webDTO = new SmsSignWebDTO();
        webDTO.setMerchantId(21L);
        webDTO.setChannelNo("998");
        webDTO.setSignId(1L);
        webDTO.setSign("东方物流");
        webDTO.setOldSign("东方物流管理");
        String reqJson  = JSONObject.toJSONString(webDTO);
        String postStr = "/cloud/sms/updateSign/v1.0.0";
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
