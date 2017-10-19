package com.shfc.cloud.area;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *区域板块测试
 * @author wky
 * @version V1.0
 * @create 2017-03-16 15:22
 **/
public class AreaControllerTest extends JunitBaseMockMvcTest{

    @Test
    public void testQueryArea() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/area/queryArea/v1.1")
                .param("reqJson","{\"cityId\":\"310000\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();


    }


}
