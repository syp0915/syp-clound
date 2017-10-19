package com.shfc.cloud.container;

import com.shfc.cloud.JunitBaseMockMvcTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package com.shfc.cloud.container.ContainerManagerControllerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 13:57
 * version V1.0.0
 */
public class ContainerManagerControllerTest extends JunitBaseMockMvcTest{
	@Test
	public void testServerDeployReq() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/cloud/containerManager/serverDeployReq/v1.0")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"merchantId\":\"1111\",\"channelId\":\"999\",\"warId\":\"111\"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testServerDeployRollbackReq() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/cloud/containerManager/serverDeployRollbackReq/v1.0")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"merchantId\":\"1111\",\"channelId\":\"999\",\"warId\":\"111\",\"rollWarName\":\"app999.war\",\"rollWarVersion\":\"v1.0\"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testServerRestartReq() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/cloud/containerManager/serverRestartReq/v1.0")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"merchantId\":\"1111\",\"channelId\":\"999\"}")
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}
}
