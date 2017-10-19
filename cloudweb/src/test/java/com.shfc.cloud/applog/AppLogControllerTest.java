package com.shfc.cloud.applog;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.applog.AppLogControllerTest
 * @Description: AppLogController
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/16 11:14
 * version V1.0.0
 */
public class AppLogControllerTest extends JunitBaseMockMvcTest {
    @Test
    public void testDir() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/appLog/dir/v1.0.0")
                .param("reqJson", "{\"merchantId\":120}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
//                .andExpect(MockMvcResultMatchers.content().string("{\"success\":true,\"errMsg\":null,\"errCode\":0,\"data\":{\"currentPath\":\"/logs/1001\",\"dirs\":[\"999\",\"997\"]}}"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testDownload() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/appLog/download/v1.0.0")
                .param("reqJson", "{\"merchantId\":120}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
