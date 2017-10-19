package com.shfc.cloud.container.manager;

import com.shfc.cloud.cloudbase.domain.SourceVirtual;
import com.shfc.cloud.cloudbase.service.SourceVirtualService;
import com.shfc.cloud.container.constant.ContainerErrorConstant;
import com.shfc.cloud.container.constant.WarLogTypeEnum;
import com.shfc.cloud.container.constant.WarStatusEnum;
import com.shfc.cloud.container.dao.WarLogMapper;
import com.shfc.cloud.container.dao.WarPackageMapper;
import com.shfc.cloud.container.domain.WarLog;
import com.shfc.cloud.container.domain.WarPackage;
import com.shfc.cloud.container.dto.ContainerBaseDTO;
import com.shfc.cloud.container.dto.WarDeployDTO;
import com.shfc.cloud.container.dto.WarRollbackDTO;
import com.shfc.cloud.container.util.ExecuteCommand;
import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.cloud.container.manager.ContainerManagerManager
 * @Description: war包部署业务逻辑处理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 16:24
 * version V1.0.0
 */
@Service
public class ContainerMonitorManager {
	@Autowired
	private WarPackageMapper warPackageMapper;
	@Autowired
	private WarLogMapper warLogMapper;

	@Autowired
	private SourceVirtualService sourceVirtualService;

	/**
	 * war 包部署方法
	 *
	 * @param reqDto
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public ResultDO warDeploy(WarDeployDTO reqDto){
		ResultDO result = new ResultDO();

		SourceVirtual virtualParam = new SourceVirtual();
		virtualParam.setMerchantId(reqDto.getMerchantId());
		virtualParam.setChannelNumber(reqDto.getChannelNo());
		ResultDO<List<SourceVirtual>> svDO = sourceVirtualService.selectByDomainList(virtualParam);
		if(!svDO.isSuccess()||svDO.getData()==null){
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getCode());
			result.setErrMsg(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getMsg());
			return result;
		}
		List<SourceVirtual> sourceVirtualList = svDO.getData();
		SourceVirtual virtual = null;
		if(sourceVirtualList!=null && sourceVirtualList.size()==1){
			virtual = sourceVirtualList.get(0);
		}else{
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getCode());
			result.setErrMsg(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getMsg());
			return result;
		}
		WarPackage warPackage = warPackageMapper.selectByPrimaryKey(Long.parseLong(reqDto.getWarId()));

        try{
			String destfile = warPackage.getWarName().substring(0,warPackage.getWarName().indexOf(".war"));
			String cmd = "ansible-playbook -i "+virtual.getIp()+", /home/tomcat/ansible/tomcat_release.yml -t release  " +
					"-e srcfile="+warPackage.getWarUrl()+"/"+warPackage.getWarRealname()+" -e destfile="+destfile;
//			String cmd = "id";
			Logger.info(this.getClass(),"war包部署执行脚本："+cmd);
			int status = ExecuteCommand.executeCmdRetStatus(cmd);
			result.setSuccess(true);
			result.setData(status);
			if(status==0){//执行成功
				warPackage.setStatus(WarStatusEnum.USEING.getValue());
				warPackageMapper.updateStatusByWar(warPackage);//把使用中状态的war包状态更新为已停用
				warPackageMapper.updateByPrimaryKey(warPackage);//设置当前war包成使用中状态

				WarLog warLog = getWarLog(warPackage,WarLogTypeEnum.DEPLOY.getValue(),0);
				warLogMapper.insert(warLog);
				result.setSuccess(true);
				result.setErrMsg("部署成功");
			}else{
				warPackage.setStatus(WarStatusEnum.DEPLOY_ERROR.getValue());
				warPackageMapper.updateByPrimaryKey(warPackage);//设置当前war包成部署失败状态
				WarLog warLog = getWarLog(warPackage,WarLogTypeEnum.DEPLOY.getValue(),1);
				warLogMapper.insert(warLog);
				result.setSuccess(false);
				result.setErrCode(ContainerErrorConstant.WAR_DEPLOY_ERROR.getCode());
				result.setErrMsg(ContainerErrorConstant.WAR_DEPLOY_ERROR.getMsg());
			}
		}catch (Exception e){
			Logger.error(ContainerMonitorManager.class,"war包部署处理异常",e);
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.WAR_DEPLOY_ERROR.getCode());
			result.setErrMsg(ContainerErrorConstant.WAR_DEPLOY_ERROR.getMsg());
			return result;
		}

		return result;
	}

	private WarLog getWarLog(WarPackage warPackage,Integer type,Integer isSucc) {
		WarLog warLog = new WarLog();
		warLog.setWarId(warPackage.getId());
		warLog.setMerchantId(warPackage.getMerchantId());
		warLog.setChannelNo(warPackage.getChannelNo());
		warLog.setType(type);
		warLog.setIsSuccess(isSucc);
		warLog.setCreateTime(new Date());
		return warLog;
	}

	/**
	 * 服务器回滚
	 * @param reqDto
	 * @return
	 */
	public ResultDO warRollback(WarRollbackDTO reqDto){
		ResultDO result = new ResultDO();

		SourceVirtual virtualParam = new SourceVirtual();
		virtualParam.setMerchantId(reqDto.getMerchantId());
		virtualParam.setChannelNumber(reqDto.getChannelNo());
		ResultDO<List<SourceVirtual>> svDO = sourceVirtualService.selectByDomainList(virtualParam);
		if(!svDO.isSuccess()||svDO.getData()==null){
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getCode());
			result.setErrMsg(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getMsg());
			return result;
		}
		List<SourceVirtual> sourceVirtualList = svDO.getData();
		SourceVirtual virtual = null;
		if(sourceVirtualList!=null && sourceVirtualList.size()==1){
			virtual = sourceVirtualList.get(0);
		}else{
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getCode());
			result.setErrMsg(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getMsg());
			return result;
		}


		WarPackage warPackage = warPackageMapper.selectByWarNameAndVersion(reqDto);
		if(ValidateHelper.isEmpty(warPackage)){
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.WAR_NOT_EXIST.getCode());
			result.setErrMsg(ContainerErrorConstant.WAR_NOT_EXIST.getMsg());
			return result;
		}

		try{
			String cmd = "ansible-playbook -i "+virtual.getIp()+", /home/tomcat/ansible/tomcat_release.yml -t rollback -e service="+reqDto.getRollWarName()+"";
			Logger.info(this.getClass(),"tomcat回滚执行脚本："+cmd);
			int status = ExecuteCommand.executeCmdRetStatus(cmd);
			if(status==0){
				WarLog warLog = getWarLog(warPackage,WarLogTypeEnum.ROLLBACK.getValue(),0);//0:成功 1：失败
				warLogMapper.insert(warLog);
				result.setSuccess(true);
				result.setErrMsg("回滚处理成功");
			}else{
				WarLog warLog = getWarLog(warPackage,WarLogTypeEnum.ROLLBACK.getValue(),1);
				warLogMapper.insert(warLog);
				result.setSuccess(false);
				result.setErrCode(ContainerErrorConstant.WAR_ROLLBACK_ERROR.getCode());
				result.setErrMsg(ContainerErrorConstant.WAR_ROLLBACK_ERROR.getMsg());
			}

			result.setData(status);
		}catch (Exception e){
			Logger.error(ContainerMonitorManager.class,"war包部署处理异常",e);
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.WAR_DEPLOY_ERROR.getCode());
			result.setErrMsg(ContainerErrorConstant.WAR_DEPLOY_ERROR.getMsg());
			return result;
		}

		return result;
	}

	/**
	 * 服务器重启
	 * @param reqDto
	 * @return
	 */
	public ResultDO serverRestart(ContainerBaseDTO reqDto) {
		ResultDO result = new ResultDO();
		SourceVirtual virtualParam = new SourceVirtual();
		virtualParam.setMerchantId(reqDto.getMerchantId());
		virtualParam.setChannelNumber(reqDto.getChannelNo());
		ResultDO<List<SourceVirtual>> svDO = sourceVirtualService.selectByDomainList(virtualParam);
		if(!svDO.isSuccess()||svDO.getData()==null){
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getCode());
			result.setErrMsg(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getMsg());
			return result;
		}
		List<SourceVirtual> sourceVirtualList = svDO.getData();
		SourceVirtual virtual = null;
		if(sourceVirtualList!=null && sourceVirtualList.size()==1){
			virtual = sourceVirtualList.get(0);
		}else{
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getCode());
			result.setErrMsg(ContainerErrorConstant.VIRTUAL_NOT_EXIT.getMsg());
			return result;
		}

		try{
			String cmd = "ansible-playbook -i "+virtual.getIp()+", /home/tomcat/ansible/tomcat_release.yml -t restart ";
			Logger.info(this.getClass(),"执行重启脚本："+cmd);
			int status = ExecuteCommand.executeCmdRetStatus(cmd);
			if(status==0){
				WarLog warLog = getRestartLog(reqDto,0);
				warLogMapper.insert(warLog);
				result.setSuccess(true);
				result.setErrMsg("服务器重启成功");
			}else{
				WarLog warLog = getRestartLog(reqDto,1);
				warLogMapper.insert(warLog);
				result.setSuccess(false);
				result.setErrCode(ContainerErrorConstant.WAR_RESTART_ERROR.getCode());
				result.setErrMsg(ContainerErrorConstant.WAR_RESTART_ERROR.getMsg());
			}
			result.setData(status);
		}catch (Exception e){
			Logger.error(ContainerMonitorManager.class,"war包部署处理异常",e);
			result.setSuccess(false);
			result.setErrCode(ContainerErrorConstant.WAR_DEPLOY_ERROR.getCode());
			result.setErrMsg(ContainerErrorConstant.WAR_DEPLOY_ERROR.getMsg());
			return result;
		}

		return result;
	}

	private WarLog getRestartLog(ContainerBaseDTO reqDto, int isSucc) {
		WarLog warLog = new WarLog();
		warLog.setMerchantId(reqDto.getMerchantId());
		warLog.setChannelNo(reqDto.getChannelNo());
		warLog.setType(WarLogTypeEnum.RESTART.getValue());
		warLog.setIsSuccess(isSucc);
		warLog.setCreateTime(new Date());
		return warLog;
	}
}
