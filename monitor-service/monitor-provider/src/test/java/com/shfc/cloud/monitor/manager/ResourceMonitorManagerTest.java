package com.shfc.cloud.monitor.manager;

import com.alibaba.druid.filter.AutoLoad;
import com.shfc.cloud.monitor.JunitBaseTest;
import com.shfc.cloud.monitor.dto.MonitorBaseDTO;
import com.shfc.common.result.ResultDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.cloud.monitor.manager.ResourceMonitorManagerTest
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/28 14:45
 * version V1.0.0
 */
public class ResourceMonitorManagerTest extends JunitBaseTest {
	@Autowired
	private ResourceMonitorManager resourceMonitorManager;

	@Test
    public void testGetImgCurrentData(){
		MonitorBaseDTO dto = new MonitorBaseDTO();
		dto.setMerchantId(1L);
		dto.setChannelNo("999");
		ResultDO resultDO = resourceMonitorManager.getImgCurrentData(dto);
	}

	@Test
	public void testGetDiskUsesNum(){
		MonitorBaseDTO dto = new MonitorBaseDTO();
		dto.setMerchantId(1L);
		dto.setChannelNo("999");
		ResultDO resultDO = resourceMonitorManager.getDiskUsesNum(dto);
	}

	@Test
	public void testGetDbMonitorDetail(){
		MonitorBaseDTO dto = new MonitorBaseDTO();
		dto.setMerchantId(1L);
		dto.setChannelNo("999");
		ResultDO resultDO = resourceMonitorManager.getDbMonitorDetail(dto);
	}

}
