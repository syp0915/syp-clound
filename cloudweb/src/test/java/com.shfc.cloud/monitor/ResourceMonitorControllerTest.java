package com.shfc.cloud.monitor;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.monitor.ResourceMonitorControllerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 13:17
 * version V1.0.0
 */
public class ResourceMonitorControllerTest extends JunitBaseMockMvcTest {
	@Test
	public void testGetResLastedData() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/monitor/resMonitor/getLastedMonitorData/v1.0")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"merchantId\":1,\"channelNo\":\"999\"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testGetResMonitorDetail() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/monitor/resMonitor/getResMonitorDetail/v1.0")
				.param("reqJson","{\"merchantId\":\"1111\",\"channelId\":\"999\",\"resourceType\":\"1\",\"timeType\":\"60m\"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testGetCacheMonitorDetail() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/monitor/resMonitor/getCacheMonitorDetail/v1.0")
				.param("reqJson","{\"merchantId\":\"1111\",\"channelId\":\"999\"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testGetImgMonitorDetail() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/monitor/resMonitor/getImgMonitorDetail/v1.0")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"apiKey\": \"a6b9e216b8be4a37bd9e9aee92ef5bb8\",\n" +
						"    \"timestamp\": 1491466356433,\n" +
						"    \"signature\": \"S7GBZrfE5urnGhRq3iS3wLooySmjskJrrQtL6gGS/qE=\",\n" +
						"    \"reqJson\":{\"channelNo\":\"997\",\"merchantId\":2}\n" +
						"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testGetDBMonitorDetail() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/monitor/resMonitor/getDBMonitorDetail/v1.0")
				.param("reqJson","{\"merchantId\":\"1111\",\"channelId\":\"999\"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testGetServerStatus() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/monitor/resMonitor/getServerStatus/v1.0")
				.param("reqJson","{\"merchantId\":\"1111\",\"channelId\":\"999\"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}
}
