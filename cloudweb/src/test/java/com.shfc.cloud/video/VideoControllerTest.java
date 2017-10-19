package com.shfc.cloud.video;

import com.shfc.cloud.JunitBaseMockMvcTest;
import com.shfc.cloud.video.ao.VideoAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.resource.ResourceControllerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/18 10:51
 * version V1.0.0
 */
public class VideoControllerTest extends JunitBaseMockMvcTest {

    @Autowired
    private VideoAO resourceAO;

    @Test
    public void testResourceList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/resourceList/v1.0.0")
                .param("reqJson", "{\"channelNo\":\"996\",\"type\":\"0\",\"startDate\":\"2017-03-16\",\"endDate\":\"2017-03-18\",\"status\":\"0\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Test
    public void testResourceInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/resourceInfo/v1.0.0")
                .param("reqJson", "{\"fileId\":\"122\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testUploadFile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/uploadFile/v1.0.0")
                .param("reqJson", "{\"channelNo\":\"996\",\"file\":\"null\",\"type\":\"video\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testImgZoom() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/imgZoom/v1.0.0")
                .param("reqJson", "{\"imgid\":\"996\",\"width\":\"300\",\"height\":\"400\",\"size\":\"1\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testVideoTranscod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/videoTranscod/v1.0.0")
                .param("reqJson", "{\"channelNo\":\"996\",\"fileid\":\"112\",\"fileurl\":\"\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Test
    public void testResourceCheck() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/resourceCheck/v1.0.0")
                .param("reqJson", "{\"channelNo\":\"996\",\"approverId\":\"11\",\"fileId\":\"12\",\"status\":\"1\",\"reason\":\"同意\",\"isclear\":\"0\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testUploadWar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/uploadWar/v1.0.0")
                .param("reqJson", "{\"channelNo\":\"996\",\"uploadId\":\"12\",\"environment\":\"0\",\"warContent\":\"null\",\"warName\":\"app.war\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testDownloadWar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/downloadWar/v1.0.0")
                .param("reqJson", "{\"warId\":\"12\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testWarlist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cloud/video/warlist/v1.0.0")
                .param("reqJson", "{\"channelNo\":\"995\",\"status\":\"0\"}")
                .accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
