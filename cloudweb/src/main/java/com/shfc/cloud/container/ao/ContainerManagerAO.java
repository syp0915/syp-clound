package com.shfc.cloud.container.ao;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.common.ao.BaseAO;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.container.dto.*;
import com.shfc.cloud.container.service.ContainerManageService;
import com.shfc.cloud.monitor.dto.BaseWebDTO;
import com.shfc.cloud.monitor.dto.ResMonitorDetailWebDTO;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.container.ao.ContainerManagerAO
 * @Description: 容器管理AO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/18 10:23
 * version V1.0.0
 */
@Service
public class ContainerManagerAO extends BaseAO{

	@Autowired
	private ContainerManageService containerManageService;

	/**
	 * war包部署
	 * @param reqJson
	 * @return
	 */
	public ResultDO serverDeployReq(WarDeployWebDTO reqJson) {
		WarDeployDTO deployDTO = new WarDeployDTO();
		ResultDO checkDO = checkServerDeployReqData(reqJson);
		if(!checkDO.isSuccess()){
			return checkDO;
		}else{
			BeanUtils.copyProperties(reqJson,deployDTO);
			return containerManageService.warDeploy(deployDTO);
		}
	}

	/**
	 * war包回滚
	 * @param reqJson
	 * @return
	 */
	public ResultDO<JSONObject> serverDeployRollback(WarRollbackWebDTO reqJson) {
		WarRollbackDTO reqDto = new WarRollbackDTO();
		ResultDO checkDO = checkServerRollbackData(reqJson);
		if(!checkDO.isSuccess()){
			return checkDO;
		}else{
			BeanUtils.copyProperties(reqJson,reqDto);
			return containerManageService.warRollback(reqDto);
		}
	}

	/**
	 * tmcat重启
	 * @param reqJson
	 * @return
	 */
	public ResultDO<JSONObject> serverRestartReq(BaseWebDTO reqJson) {
		ContainerBaseDTO reqDto = new ContainerBaseDTO();
		ResultDO checkDO = checkCommonData(reqJson.getMerchantId(),reqJson.getChannelNo());
		if(!checkDO.isSuccess()){
			return checkDO;
		}else{
			BeanUtils.copyProperties(reqJson,reqDto);
			return containerManageService.serverRestart(reqDto);
		}
	}

	private ResultDO checkServerRollbackData(WarRollbackWebDTO reqJson) {
		ResultDO checkDO = checkCommonData(reqJson.getMerchantId(),reqJson.getChannelNo());
		if(!checkDO.isSuccess()){
			return checkDO;
		}else{
			if(ValidateHelper.isEmpty(reqJson.getRollWarName())){
				checkDO.setSuccess(false);
				checkDO.setErrCode(ErrorConstant.NULL_WAR_NAME.getCode());
				checkDO.setErrMsg(ErrorConstant.NULL_WAR_NAME.getMsg());
				return checkDO;
			}

		}
		checkDO.setSuccess(true);
		return checkDO;
	}

	protected ResultDO checkServerDeployReqData(WarDeployWebDTO reqDTO) {
		ResultDO checkDO = checkCommonData(reqDTO.getMerchantId(),reqDTO.getChannelNo());
		if(!checkDO.isSuccess()){
			return checkDO;
		}else{
			if(ValidateHelper.isEmpty(reqDTO.getWarId())){
				checkDO.setSuccess(false);
				checkDO.setErrCode(ErrorConstant.NULL_WAR_ID.getCode());
				checkDO.setErrMsg(ErrorConstant.NULL_WAR_ID.getMsg());
				return checkDO;
			}
		}
		checkDO.setSuccess(true);
		return checkDO;
	}

}
