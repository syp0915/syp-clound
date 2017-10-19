package com.shfc.cloud.monitor.ao;

import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.cloudbase.dto.*;
import com.shfc.cloud.cloudbase.service.ChannelService;
import com.shfc.cloud.common.ao.BaseAO;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.monitor.dto.*;
import com.shfc.cloud.monitor.dto.ChannelDTO;
import com.shfc.cloud.monitor.service.ResourceMonitorService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.cloud.monitor.ao.ResourceMonitorAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/18 10:40
 * version V1.0.0
 */
@Service
public class ResourceMonitorAO extends BaseAO{

	@Autowired
	private ResourceMonitorService resourceMonitorService;

	@Autowired
	private ChannelService channelService;

	@Value("${php.merchant.no}")
	private String merchant_number_php;

	/**
	 * 获取最新资源监控数据
	 *
	 * @param reqJson
	 * @return
	 */
	public ResultDO<MonitorCurrentDTO> getLastedMonitorData(BaseWebDTO reqJson){
		ResultDO<JSONObject> result = new ResultDO<JSONObject>();

		ResultDO checkResult = checkCommonData(reqJson.getMerchantId(),reqJson.getChannelNo());
		if(!checkResult.isSuccess()){
			return checkResult;
		}else{
			if(!ValidateHelper.isEmpty(reqJson.getMerchantId())
					&& Long.parseLong(merchant_number_php)==reqJson.getMerchantId()){
				ResultDO<com.shfc.cloud.cloudbase.dto.ChannelDTO> channelDO = channelService.queryChannelByNo(reqJson.getChannelNo());

				if(channelDO.isSuccess()){
					com.shfc.cloud.cloudbase.dto.ChannelDTO channel = channelDO.getData();
					reqJson.setMerchantId(Long.parseLong(channel.getMerchantNo()));
				}

			}

			MonitorBaseDTO monitorBaseDTO = new MonitorBaseDTO();
			monitorBaseDTO.setMerchantId(reqJson.getMerchantId());
			monitorBaseDTO.setChannelNo(reqJson.getChannelNo());
			ResultDO<MonitorCurrentDTO> monitorDO = resourceMonitorService.getLastedMonitorData(monitorBaseDTO);
			return monitorDO;
		}

	}

	/**
	 * 获取资源监控详情列表数据
	 * @param reqJson
	 * @return
	 */
	public ResultDO<ResourceMonitorDetailDTO> getResMonitorDetailData(ResMonitorDetailWebDTO reqJson){
		ResultDO<JSONObject> result = new ResultDO<JSONObject>();
		ResultDO checkResult = checkResMonitorDetailData(reqJson);
		if(!checkResult.isSuccess()){
			return checkResult;
		}else{
			if(!ValidateHelper.isEmpty(reqJson.getMerchantId())
					&& Long.parseLong(merchant_number_php)==reqJson.getMerchantId()){
				ResultDO<com.shfc.cloud.cloudbase.dto.ChannelDTO> channelDO = channelService.queryChannelByNo(reqJson.getChannelNo());

				if(channelDO.isSuccess()){
					com.shfc.cloud.cloudbase.dto.ChannelDTO channel = channelDO.getData();
					reqJson.setMerchantId(Long.parseLong(channel.getMerchantNo()));
				}

			}
			ResMonitorDetailDTO detailDTO = new ResMonitorDetailDTO();
			BeanUtils.copyProperties(reqJson,detailDTO);
			ResultDO<ResourceMonitorDetailDTO> monitorDO = resourceMonitorService.getResourceMonitorDetail(detailDTO);
			return monitorDO;
		}
	}

	/**
	 * 获取图片空间监控详情
	 * @param reqJson
	 * @return
	 */
	public ResultDO<SpaceUseMonitorDetailDTO> getImgMonitorDetail(BaseWebDTO reqJson){
		MonitorBaseDTO detailDTO = new MonitorBaseDTO();
		ResultDO checkResult = checkCommonData(reqJson.getMerchantId(),reqJson.getChannelNo());
		if(!checkResult.isSuccess()){
			return checkResult;
		}else {
			if(!ValidateHelper.isEmpty(reqJson.getMerchantId())
					&& Long.parseLong(merchant_number_php)==reqJson.getMerchantId()){
				ResultDO<com.shfc.cloud.cloudbase.dto.ChannelDTO> channelDO = channelService.queryChannelByNo(reqJson.getChannelNo());

				if(channelDO.isSuccess()){
					com.shfc.cloud.cloudbase.dto.ChannelDTO channel = channelDO.getData();
					reqJson.setMerchantId(Long.parseLong(channel.getMerchantNo()));
				}

			}

			BeanUtils.copyProperties(reqJson, detailDTO);
			return resourceMonitorService.getImgMonitorDetail(detailDTO);
		}
	}

	/**
	 * 获取DB空间监控详情
	 * @param reqJson
	 * @return
	 */
	public ResultDO<SpaceUseMonitorDetailDTO> getDBMonitorDetail(BaseWebDTO reqJson) {
		MonitorBaseDTO detailDTO = new MonitorBaseDTO();
		ResultDO checkResult = checkCommonData(reqJson.getMerchantId(),reqJson.getChannelNo());
		if(!checkResult.isSuccess()){
			return checkResult;
		}else {
			if(!ValidateHelper.isEmpty(reqJson.getMerchantId())
					&& Long.parseLong(merchant_number_php)==reqJson.getMerchantId()){
				ResultDO<com.shfc.cloud.cloudbase.dto.ChannelDTO> channelDO = channelService.queryChannelByNo(reqJson.getChannelNo());

				if(channelDO.isSuccess()){
					com.shfc.cloud.cloudbase.dto.ChannelDTO channel = channelDO.getData();
					reqJson.setMerchantId(Long.parseLong(channel.getMerchantNo()));
				}

			}

			BeanUtils.copyProperties(reqJson, detailDTO);
			return resourceMonitorService.getDBMonitorDetail(detailDTO);
		}
	}

	/**
	 * 获取tomcat运行状态
	 * @param reqJson
	 * @return
	 */
	public ResultDO getServerStatus(BaseWebDTO reqJson) {
		MonitorBaseDTO detailDTO = new MonitorBaseDTO();
		ResultDO checkResult = checkCommonData(reqJson.getMerchantId(),reqJson.getChannelNo());
		if(!checkResult.isSuccess()){
			return checkResult;
		}else {
			if(!ValidateHelper.isEmpty(reqJson.getMerchantId())
					&& Long.parseLong(merchant_number_php)==reqJson.getMerchantId()){
				ResultDO<com.shfc.cloud.cloudbase.dto.ChannelDTO> channelDO = channelService.queryChannelByNo(reqJson.getChannelNo());

				if(channelDO.isSuccess()){
					com.shfc.cloud.cloudbase.dto.ChannelDTO channel = channelDO.getData();
					reqJson.setMerchantId(Long.parseLong(channel.getMerchantNo()));
				}

			}

			BeanUtils.copyProperties(reqJson, detailDTO);
			return resourceMonitorService.getServerStatus(detailDTO);
		}
	}

	private ResultDO checkResMonitorDetailData(ResMonitorDetailWebDTO reqDTO) {
		ResultDO checkDO = checkCommonData(reqDTO.getMerchantId(),reqDTO.getChannelNo());

		if(!checkDO.isSuccess()){
			return checkDO;
		}else{
			if(ValidateHelper.isEmpty(reqDTO.getResourceType())){
				checkDO.setSuccess(false);
				checkDO.setErrCode(ErrorConstant.NULL_RESOURCE_TYPE.getCode());
				checkDO.setErrMsg(ErrorConstant.NULL_RESOURCE_TYPE.getMsg());
				return checkDO;
			}
			if((!"1".equals(reqDTO.getResourceType())) && (!"3".equals(reqDTO.getResourceType()))){
				checkDO.setSuccess(false);
				checkDO.setErrCode(ErrorConstant.ERROR_RESOURCE_TYPE.getCode());
				checkDO.setErrMsg(ErrorConstant.ERROR_RESOURCE_TYPE.getMsg());
				return checkDO;
			}

		}

		checkDO.setSuccess(true);

		return checkDO;
	}

	public ResultDO getCacheMonitorDetail(BaseWebDTO reqJson) {
		ResultDO result = new ResultDO();
		MonitorBaseDTO monitorBaseDto=new MonitorBaseDTO();
		if(ValidateHelper.isEmptyString(reqJson.getChannelNo())){
			result.setErrMsg("频道号不能为空");
			result.setSuccess(false);
		}
		if(reqJson.getMerchantId()==null){
			result.setErrMsg("商户号不能为空");
			result.setSuccess(false);
		}
		BeanUtils.copyProperties(reqJson,monitorBaseDto);
		result=resourceMonitorService.getCacheMonitorDetail(monitorBaseDto);
		return result;
	}

	public ResultDO<SpaceUseMonitorDetailDTO> getDiskMonitorDetail(BaseWebDTO reqJson) {
		ResultDO result = new ResultDO();
		MonitorBaseDTO monitorBaseDto=new MonitorBaseDTO();
		if(ValidateHelper.isEmptyString(reqJson.getChannelNo())){
			result.setErrMsg("频道号不能为空");
			result.setSuccess(false);
		}
		if(reqJson.getMerchantId()==null){
			result.setErrMsg("商户号不能为空");
			result.setSuccess(false);
		}
		BeanUtils.copyProperties(reqJson,monitorBaseDto);
		result=resourceMonitorService.getDiskMonitorDetail(monitorBaseDto);
		return result;
	}
}
