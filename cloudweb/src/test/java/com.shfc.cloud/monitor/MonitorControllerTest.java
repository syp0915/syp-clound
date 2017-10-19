package com.shfc.cloud.monitor;

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
 * @create 2017-03-20 14:17
 **/
public class MonitorControllerTest extends JunitBaseMockMvcTest{

    @Test
    public void testActualStatistics() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/monitor/graphic/actualStatistics/v1.0.0")
                .param("reqJson","{\"period\":900000}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();


    }

    @Test
    public void testDistrictTrend() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/monitor/graphic/districtTrend/v1.0.0")
                .param("reqJson","{\"span\":86400000,\"queryLevel\":1,\"districtId\":310115}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();


    }

    @Test
    public void testTimeTrend() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/monitor/graphic/timeTrend/v1.0.0")
                .param("reqJson","{\"scale\":3600000,\"span\":86400000}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();


    }


    @Test
    public void testStatisticsList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/monitor/list/statisticsList/v1.1")
                .param("reqJson","{\"pageSize\":3,\"pageNumber\":1}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();


    }


    @Test
    public void testChannelList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/monitor/list/channelList/v1.1")
                .param("reqJson","{\"channelNo\":\"999\",\"pageSize\":3,\"pageNumber\":1}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();


    }

}
