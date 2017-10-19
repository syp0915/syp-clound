package com.shfc.cloud.account;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.account.AccountControllerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/17 13:41
 * version V1.0.0
 */
public class AccountControllerTest extends JunitBaseMockMvcTest {

    @Test
    public void testUserInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/account/userInfo/v1.0.0")
                .param("reqJson", "{\"merchantId\":120}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testUserList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/account/userList/v1.0.0")
                .param("reqJson", "{\"merchantNo\":\"997\",\"account\":\"1222\",\"companyName\":\"0\",\"status\":\"0\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testCutMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/account/cutMessage/v1.0.0")
                .param("reqJson", "{\"merchantNo\":\"997\",\"number\":\"12\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testCutMedia() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/account/cutMedia/v1.0.0")
                .param("reqJson", "{\"merchantNo\":\"997\",\"type\":\"image\",\"size\":\"220\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testCutVoice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/account/cutVoice/v1.0.0")
                .param("reqJson", "{\"merchantNo\":\"997\",\"number\":\"22\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testCutAuthenticate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/account/cutAuthenticate/v1.0.0")
                .param("reqJson", "{\"merchantNo\":\"997\",\"number\":\"22\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
