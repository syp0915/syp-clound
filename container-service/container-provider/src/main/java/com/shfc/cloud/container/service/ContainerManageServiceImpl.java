package com.shfc.cloud.container.service;

import com.shfc.cloud.container.constant.ContainerErrorConstant;
import com.shfc.cloud.container.dto.ContainerBaseDTO;
import com.shfc.cloud.container.dto.WarDeployDTO;
import com.shfc.cloud.container.dto.WarRollbackDTO;
import com.shfc.cloud.container.manager.ContainerMonitorManager;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.container.service.ContainerManageServiceImpl
 * @Description: 容器管理服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 16:07
 * version V1.0.0
 */
@Service
public class ContainerManageServiceImpl implements ContainerManageService {

	@Autowired
	private ContainerMonitorManager containerManagerManager;

	@Override
	public ResultDO warDeploy(WarDeployDTO reqDto) {
		ResultDO result = containerManagerManager.warDeploy(reqDto);
		return result;
	}

	@Override
	public ResultDO warRollback(WarRollbackDTO reqDto) {
		ResultDO checkDO = checkWarRollback(reqDto);
		if(!checkDO.isSuccess()){
            return checkDO;
		}
		ResultDO result = containerManagerManager.warRollback(reqDto);
		return result;
	}

	private ResultDO checkWarRollback(WarRollbackDTO reqDto) {
		ResultDO checkDO = new ResultDO();
		if(ValidateHelper.isEmpty(reqDto.getRollWarName())
				|| ValidateHelper.isEmpty(reqDto.getRollWarVersion())){
			checkDO.setSuccess(false);
			checkDO.setErrCode(ContainerErrorConstant.NULL_MUST_INPUT.getCode());
			checkDO.setErrMsg(ContainerErrorConstant.NULL_MUST_INPUT.getMsg());
			return checkDO;
		}

		checkDO.setSuccess(true);
		return checkDO;
	}

	@Override
	public ResultDO serverRestart(ContainerBaseDTO reqDto) {
		ResultDO result = containerManagerManager.serverRestart(reqDto);
		return result;
	}
}
