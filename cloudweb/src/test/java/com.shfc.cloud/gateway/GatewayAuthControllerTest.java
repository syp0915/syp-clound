package com.shfc.cloud.gateway;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/31 14:26
 * @since 1.0
 */
public class GatewayAuthControllerTest extends JunitBaseMockMvcTest {
    @Test
    public void testInsert() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/sensitive/insert/v1.0.0")
                .param("reqJson","{\"channelNo\": \"NO001\",\"endTime\": \"20180330\",\"merchantId\":1,\"startTime\": \"20170330\",\"validity\": 12}")
                .accept("application/json;charset=UTF-8"))
                //  .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testSelect() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/sensitive/select/v1.0.0")
                .param("reqJson","{\"merchantId\":\"1\",\"channelNo\":\"NO001\"}")
                .accept("application/json;charset=UTF-8"))
                //  .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testDel() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/sensitive/delete/v1.0.0")
                .param("reqJson","{\"id\":1}")
                .accept("application/json;charset=UTF-8"))
                //  .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testUpdate() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/sensitive/delete/v1.0.0")
                .param("reqJson","{\"channelNo\": \"NO002\",\"endTime\": \"20180323\",\"id\": 1,\"merchantId\": 1, \"startTime\": \"20170323\", \"validity\": 12}")
                .accept("application/json;charset=UTF-8"))
                //  .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
