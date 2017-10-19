package com.shfc.cloud.container.service;

import com.shfc.cloud.container.JunitBaseTest;
import com.shfc.cloud.container.dto.WarDeployDTO;
import com.shfc.cloud.container.manager.ContainerMonitorManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package com.shfc.cloud.container.ContainerManagerServiceImplTest
 * @Description: 容器管理接口uint test
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/22 17:23
 * version V1.0.0
 */
public class ContainerManageServiceTest extends JunitBaseTest {

	@Autowired
	private ContainerManageService containerManageService;

	@Test
	public void testWarDeploy(){
		WarDeployDTO dto = new WarDeployDTO();
		dto.setWarId("1");
		containerManageService.warDeploy(dto);
	}


}
