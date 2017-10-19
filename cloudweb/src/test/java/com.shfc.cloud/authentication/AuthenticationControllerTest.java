package com.shfc.cloud.authentication;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-16 13:55
 **/
public class AuthenticationControllerTest extends JunitBaseMockMvcTest {
    @Test
    public void testAuthenticationByInfo() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/authenticate/authenticationByInfo/v1.1")
                .param("reqJson","{\"name\":\"吴开阳\",\"id\":\"321281199002139021\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
}
