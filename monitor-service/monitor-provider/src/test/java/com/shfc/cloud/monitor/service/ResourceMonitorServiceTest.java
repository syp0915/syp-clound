package com.shfc.cloud.monitor.service;

import com.fc.common.redis.RedisUtil;
import com.shfc.cloud.monitor.JunitBaseTest;
import com.shfc.cloud.monitor.dto.MonitorBaseDTO;
import com.shfc.cloud.monitor.dto.ResMonitorDetailDTO;
import com.shfc.cloud.monitor.dto.ResourceMonitorDetailDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package com.shfc.cloud.monitor.service.ResourceMonitorServiceTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/28 9:03
 * version V1.0.0
 */
public class ResourceMonitorServiceTest extends JunitBaseTest {
	@Autowired
	private ResourceMonitorService resourceMonitorService;

	@Test
	public void testGetLastedMonitorData(){
		MonitorBaseDTO dto = new MonitorBaseDTO();
		dto.setMerchantId(1L);
		dto.setChannelNo("999");
		ResultDO result = resourceMonitorService.getLastedMonitorData(dto);
	}

	@Test
	public void testResourceMonitorDetail_24h(){
		ResMonitorDetailDTO dto = new ResMonitorDetailDTO();
		dto.setMerchantId(1L);
		dto.setChannelNo("999");
		dto.setResourceType("1");
		dto.setTimeType("24h");
		ResultDO<ResourceMonitorDetailDTO> result = resourceMonitorService.getResourceMonitorDetail(dto);
		ResourceMonitorDetailDTO detail = result.getData();

	}

	@Test
	public void testResourceMonitorDetail_60m(){
		ResMonitorDetailDTO dto = new ResMonitorDetailDTO();
		dto.setMerchantId(1L);
		dto.setChannelNo("999");
		dto.setResourceType("1");
		dto.setTimeType("60m");
		ResultDO<ResourceMonitorDetailDTO> result = resourceMonitorService.getResourceMonitorDetail(dto);
		ResourceMonitorDetailDTO detail = result.getData();

	}

	@Test
	public void testGetServerStatus(){
		MonitorBaseDTO dto = new MonitorBaseDTO();
		dto.setMerchantId(1L);
		dto.setChannelNo("999");
		ResultDO result = resourceMonitorService.getServerStatus(dto);
	}

	@Test
	public void testTime(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = System.currentTimeMillis();
		long timeFrom = time-1000*60*60*24;
		Date d = new Date(time);
		Date df = new Date(time);
		System.out.println(simpleDateFormat.format(d));
		System.out.println(simpleDateFormat.format(df));
	}

//	@Test
//	public void testRedis(){
//		RedisUtil.get()
//	}
}
