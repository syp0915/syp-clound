package com.shfc.cloud.keywords;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 关键词测试
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-17 13:58
 **/
public class KeywordControllerTest extends JunitBaseMockMvcTest {

    @Test
    public void testPlotName() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/keyword/plotName/v1.0")
        .param("reqJson","{\"keyWord\":\"沪上\",\"num\":3}")
        .accept("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
    }

    @Test
    public void testChannel() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/keyword/channel/v1.0")
        .param("reqJson","{\"keyWord\":\"99\"}")
        .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
