package com.shfc.cloud.container.service;

import com.shfc.cloud.container.dto.ContainerBaseDTO;
import com.shfc.cloud.container.dto.WarDeployDTO;
import com.shfc.cloud.container.dto.WarRollbackDTO;
import com.shfc.common.result.ResultDO;

/**
 * @Package ContainerManageService
 * @Description: 容器管理服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 15:52
 * version V1.0.0
 */
public interface ContainerManageService {
	/**
	 * war包部署服务
	 * @return
	 */
	ResultDO warDeploy(WarDeployDTO reqDto);

	/**
	 * war包回滚服务
	 * @return
	 */
	ResultDO warRollback(WarRollbackDTO reqDto);

	/**
	 * tomcat重启服务
	 * @return
	 */
	ResultDO serverRestart(ContainerBaseDTO reqDto);

}
