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
 * @version 1.0.0 createTime: 2017/3/30 17:42
 * @since 1.0
 */
public class WhilteListControllerTest extends JunitBaseMockMvcTest {
    @Test
    public void testInsert() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/whiteListManage/insert/v1.0.0")
                .param("reqJson","{\"ip\": \"192.168.200.201\", \"merchantId\": 1}")
                .accept("application/json;charset=UTF-8"))
              //  .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testSelect() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/whiteListManage/select/v1.0.0")
                .param("reqJson","{\"merchantId\": 1}")
                .accept("application/json;charset=UTF-8"))
                //  .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testDel() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/whiteListManage/delete/v1.0.0")
                .param("reqJson","{\"id\":1}")
                .accept("application/json;charset=UTF-8"))
                //  .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
