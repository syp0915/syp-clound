package com.shfc.cloud.monitor.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.shfc.cloud.account.constant.DeductConstant;
import com.shfc.cloud.account.domain.ServiceLeftSource;
import com.shfc.cloud.account.query.SelectLeftSourceQuery;
import com.shfc.cloud.account.service.AccountService;
import com.shfc.cloud.cloudbase.domain.SourceDatabase;
import com.shfc.cloud.cloudbase.domain.SourceVirtual;
import com.shfc.cloud.cloudbase.dto.ChannelDTO;
import com.shfc.cloud.cloudbase.service.ChannelService;
import com.shfc.cloud.cloudbase.service.SourceDatabaseService;
import com.shfc.cloud.cloudbase.service.SourceVirtualService;
import com.shfc.cloud.monitor.config.MonitorConfig;
import com.shfc.cloud.monitor.constant.*;
import com.shfc.cloud.monitor.dao.ServiceMonitorItemMapper;
import com.shfc.cloud.monitor.domain.ServiceMonitorItem;
import com.shfc.cloud.monitor.dto.*;
import com.shfc.cloud.monitor.util.ExecuteCommand;
import com.shfc.cloud.monitor.zabbix.ZabbixClient;
import com.shfc.cloud.video.service.VideoService;
import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.log.dto.CacheStatisticsDTO;
import com.shfc.log.service.LogStatisticsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Package com.shfc.cloud.monitor.manager.ResourceMonitorManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/23 9:17
 * version V1.0.0
 */
@Service
public class ResourceMonitorManager {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ResourceMonitorManager.class);
	@Autowired
	private ZabbixClient zabbixClient;

	@Autowired
	private SourceVirtualService sourceVirtualService;

	@Autowired
	private SourceDatabaseService sourceDatabaseService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private VideoService videoService;

	@Autowired
	private ServiceMonitorItemMapper serviceMonitorItemMapper;

	@Autowired
	private MonitorConfig monitorConfig;

	@Autowired
	private LogStatisticsService logStatisticsService;

	@Autowired
	private ChannelService channelService;

	public ResultDO<MonitorCurrentDTO> getLastedMonitorData(MonitorBaseDTO dto){
		MonitorCurrentDTO monitorCurrentDTO = new MonitorCurrentDTO();
		ResultDO result = new ResultDO();
		//获取cpu当前监控值
		ResultDO cpuDo = getCpuCurrentData(dto);
		if(cpuDo.isSuccess()){
			monitorCurrentDTO.setCpuUseRate((String)cpuDo.getData());
		}else{
			monitorCurrentDTO.setCpuUseRate("0");
		}

		//获取当前图片使用情况
		ResultDO imgDo = getImgCurrentData(dto);
		if(imgDo.isSuccess()){
			monitorCurrentDTO.setImgUseRate((String)imgDo.getData());
		}else{
			monitorCurrentDTO.setImgUseRate("0");
		}

		//获取缓存调用次数
		ResultDO<CacheStatisticsDTO> cacheDo = getCacheUsesNum(dto);
		if(cacheDo.isSuccess()){
			monitorCurrentDTO.setCatchNum(String.valueOf(cacheDo.getData().getTotalCount()));
		}else{
			monitorCurrentDTO.setCatchNum("0");
		}

		//获取数据库总空间大小
		SourceDatabase sourceDatabase = new SourceDatabase();
		sourceDatabase.setMerchantId(dto.getMerchantId());
		sourceDatabase.setChannelNo(dto.getChannelNo());
		ResultDO<List<SourceDatabase>> databaseDO = sourceDatabaseService.selectByDomainList(sourceDatabase);
		SourceDatabase database = null;
		if(!databaseDO.isSuccess()||ValidateHelper.isEmpty(databaseDO.getData())||databaseDO.getData().size()==0){
			monitorCurrentDTO.setDbUseRate("0");
		}else{
			database = databaseDO.getData().get(0);
			//获取数据库磁盘使用率
			ResultDO dbUseDo = getDBUsesNum(dto,database);
			if(dbUseDo.isSuccess()){
				String dbUsedSize = (String)dbUseDo.getData();
				Long totalSpace = database.getSpace();
				totalSpace = totalSpace*1024*1024;
				String useRate = new BigDecimal(dbUsedSize).divide(new BigDecimal(totalSpace))
						.multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
				logger.debug("totalSpace="+totalSpace+",dbUsedSize="+dbUsedSize+",useRate="+useRate);

				monitorCurrentDTO.setDbUseRate(useRate);
			}else{
				monitorCurrentDTO.setDbUseRate("0");
			}
		}

		//获取磁盘空间使用
		ResultDO diskUseDo = getDiskUsesNum(dto);
		if(cacheDo.isSuccess()){
			monitorCurrentDTO.setDiskUseSize((String)diskUseDo.getData());
		}else{
			monitorCurrentDTO.setDiskUseSize("0");
		}

		result.setSuccess(true);
		result.setData(monitorCurrentDTO);

		return result;
	}

	/**
	 * 获取磁盘空间使用大小
	 * @param dto
	 * @return
	 */
	public ResultDO getDiskUsesNum(MonitorBaseDTO dto) {
		ResultDO result = new ResultDO();
		//获取itemId
		String diskItemId = getMonitorItemId(dto.getMerchantId(),dto.getChannelNo(),ResourceTypeEnum.DISK.getValue());

		if(ValidateHelper.isEmpty(diskItemId) ){
			result.setSuccess(false);
			result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
			result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
			return result;
		}else{
			//获取磁盘当前使用空间
			String value = getItemCurrentData(diskItemId, ItemValueTypeEnum.DISK.getValue(),ResourceTypeEnum.DISK.getValue());
			if(ValidateHelper.isEmpty(value)){
				result.setSuccess(false);
				result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
				result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
				return result;
			}
			result.setSuccess(true);
//			String diskUseRate = (new BigDecimal(100.00d-Double.parseDouble(value)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue())+"";

			result.setData(value);
			return result;
		}

	}

	/**
	 * 获取db空间使用率
	 * @param dto
	 * @return
	 */
	public ResultDO getDBUsesNum(MonitorBaseDTO dto,SourceDatabase sourceDatabase) {
		ResultDO result = new ResultDO();

		String cmd = monitorConfig.getDbShellPath()+" "+sourceDatabase.getIp()+" "
				+monitorConfig.getDbfilePath()+sourceDatabase.getName();

		try{
			logger.info("执行脚本："+cmd);
			ResultDO respDO = ExecuteCommand.executeCmd(cmd);
			if(respDO.isSuccess() && !ValidateHelper.isEmpty(respDO.getData())){
				result.setSuccess(true);
				result.setData(respDO.getData());
			}else{
				result.setSuccess(false);
				result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
				result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
				return result;
			}

		}catch (Exception e){
			logger.error("执行脚本异常");
			result.setSuccess(false);
			result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
			result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
		}

		return result;
	}

	/**
	 * 获取缓存调用次数
	 * @param dto
	 * @return
	 */
	public ResultDO<CacheStatisticsDTO> getCacheUsesNum(MonitorBaseDTO dto) {
		ResultDO <CacheStatisticsDTO> result = new ResultDO();
        String channelNo=dto.getChannelNo();
		long merchantId=dto.getMerchantId();
		result =logStatisticsService.getChannelRedisUseCount(channelNo,merchantId);
		return result;
	}

	public ResultDO getImgCurrentData(MonitorBaseDTO dto) {
		ResultDO result = new ResultDO();
		ResultDO<SpaceUseMonitorDetailDTO> imgDO = getImgMonitorDetail(dto);
		SpaceUseMonitorDetailDTO spaceUseDTO = imgDO.getData();
		if(ValidateHelper.isEmpty(spaceUseDTO) || ValidateHelper.isEmpty(spaceUseDTO)){
			Logger.error(this.getClass(),"未获取到当前图片空间使用情况");
			result.setSuccess(false);
			result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
			result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
		}else{
			result.setSuccess(true);
			result.setData(spaceUseDTO.getUseRate());
		}
		return result;
	}

	public ResultDO getCpuCurrentData(MonitorBaseDTO dto){
		ResultDO result = new ResultDO();
		//获取itemId
		String cpuItemId = getMonitorItemId(dto.getMerchantId(),dto.getChannelNo(),ResourceTypeEnum.CPU.getValue());

		if(!ValidateHelper.isEmpty(cpuItemId)){
			//获取cpu当前使用率
			String value = getItemCurrentData(cpuItemId,ItemValueTypeEnum.CPU.getValue(),ResourceTypeEnum.CPU.getValue());
			if(ValidateHelper.isEmpty(value)){
				result.setSuccess(false);
				result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
				result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
				return result;
			}
//			String cpuUseRate = (new BigDecimal(100.00d-Double.parseDouble(value)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue())+"";
			result.setSuccess(true);
			result.setData(value);
			return result;
		}else{
			result.setSuccess(false);
			result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
			result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
			return result;
		}

	}

	private String getItemCurrentData(String itemId,int valueType,int resourceType){
		String value = null;
		try{
			JSONObject resObj = zabbixClient.queryHistoryByItemId(itemId,1,valueType,null,null);
			JSONArray resultArray = resObj.getJSONArray("result");
			if(!ValidateHelper.isEmpty(resultArray) && resultArray.size()==1){
				JSONObject valueObj = resultArray.getJSONObject(0);
				value = valueObj.getString("value");
				if(resourceType==ResourceTypeEnum.CPU.getValue()){
					value =new BigDecimal(value).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP).toString() ;
				}
			}else{
			}
		}catch (Exception e){
			logger.error("获取监控项数据异常，itemId="+itemId,e);
		}
		return value;
	}

	private JSONArray getItemListData(String itemId,int num,int valueType,String sortfield,String sortorder){
		JSONArray array = null;
		try{
			JSONObject resObj = zabbixClient.queryHistoryByItemId(itemId,num,valueType,sortfield,sortorder);
			array = resObj.getJSONArray("result");
		}catch (Exception e){
			logger.error("获取监控项数据异常，itemId="+itemId,e);
		}
		return array;
	}

	/**
	 * 获取主机监控项ID
	 * @param hostName
	 * @param itemKey
	 * @return
	 * @throws Exception
	 */
	private String getItemId(String hostName,String itemKey) throws Exception{
		JSONObject resultObj = zabbixClient.queryItems(hostName, itemKey);
		JSONArray resultArray = resultObj.getJSONArray("result");
		if(resultArray==null || resultArray.size()==0){
			return null;
		}

		JSONObject item = resultArray.getJSONObject(0);
		return (String)item.get("itemid");
	}

	private String getMonitorItemId(Long merchantId,String channelId,int resourceType){

		//获取虚拟机监控项信息
		ServiceMonitorItem monitorItemParam = new ServiceMonitorItem();
		monitorItemParam.setMerchantId(merchantId);
		monitorItemParam.setChannelId(channelId);
		List<ServiceMonitorItem> monitorItems = serviceMonitorItemMapper.selectByDomainList(monitorItemParam);

		ServiceMonitorItem monitorItem = null;
		if(monitorItems!=null && monitorItems.size()>0){
			monitorItem = monitorItems.get(0);
		}
		String itemId = null;
		if(monitorItem!=null){
			if(resourceType == ResourceTypeEnum.CPU.getValue()){
				itemId = monitorItem.getCpuItemId();
			}else if(resourceType == ResourceTypeEnum.DISK.getValue()){
				itemId = monitorItem.getDiskItemId();
			}
		}

		//如果配置项ID不存在，则调用zabbix接口获取itemId
		if(StringUtils.isBlank(itemId)){
			try{
				//获取虚拟机信息
				SourceVirtual sourceVirtual = new SourceVirtual();
				sourceVirtual.setMerchantId(merchantId);
				sourceVirtual.setChannelNumber(channelId);
				ResultDO<List<SourceVirtual>> sourceVirtualListDO = sourceVirtualService.selectByDomainList(sourceVirtual);
				List<SourceVirtual> sourceVirtualList = null;
				if(sourceVirtualListDO.isSuccess()){
					sourceVirtualList = sourceVirtualListDO.getData();
					if(sourceVirtualList!=null && sourceVirtualList.size()==1){
						sourceVirtual = sourceVirtualList.get(0);
					}else{
						logger.error("主机信息不存在，merchantId="+merchantId+",channelId="+channelId);
						return null;
					}
				}else{
					logger.error("主机信息不存在，merchantId="+merchantId+",channelId="+channelId);
				}
				String itemKey = getItemKey(resourceType);
				if(ValidateHelper.isEmpty(itemKey)){
					logger.error("item key 不存在");
					return null;
				}

				itemId = getItemId(sourceVirtual.getName(),itemKey);

				if(ValidateHelper.isEmpty(itemId)){
					logger.error("主机信息不存在，merchantId="+merchantId+",channelId="+channelId);
					return null;
				}

				//更新主机CPU监控项ID
				if(monitorItem==null){
					ServiceMonitorItem serviceMonitorItem = new ServiceMonitorItem();
					serviceMonitorItem.setChannelId(channelId);
					serviceMonitorItem.setMerchantId(merchantId);
					serviceMonitorItem.setHostName(sourceVirtual.getName());
					if(resourceType == ResourceTypeEnum.CPU.getValue()){
						serviceMonitorItem.setCpuItemId(itemId);;
					}else if(resourceType == ResourceTypeEnum.DISK.getValue()){
						serviceMonitorItem.setDiskItemId(itemId);
					}

					serviceMonitorItem.setCreateTime(new Date());
					serviceMonitorItemMapper.insert(serviceMonitorItem);
				}else {
					if(resourceType == ResourceTypeEnum.CPU.getValue() && StringUtils.isBlank(monitorItem.getCpuItemId())){
						monitorItem.setCpuItemId(monitorItem.getCpuItemId());;
					}else if(resourceType == ResourceTypeEnum.DISK.getValue()){
						monitorItem.setDiskItemId(monitorItem.getDiskItemId());
					}

					monitorItem.setHostName(sourceVirtual.getName());
					monitorItem.setModifyTime(new Date());
					serviceMonitorItemMapper.updateByPrimaryKeySelective(monitorItem);
				}

			}catch (Exception e){
				logger.error("获取cpu item id 异常",e);
			}
		}

		return itemId;
	}

	private String getItemKey(int resourceType) {
		String itemKey = null;
		switch (resourceType){
			case 1:
				itemKey = MonitorItemKeyConstant.CPU_ITEM_KEY;
				break;
//			case 2:
//				itemKey =MonitorItemKeyConstant.DB_ITEM_KEY;
//				break;
			case 3:
				itemKey =MonitorItemKeyConstant.DISK_ITEM_KEY;
				break;
			default:
				break;

		}

		return itemKey;
	}

	/**
	 * 获取cpu监控详情列表
	 * @param dto
	 * @return
	 */
	public ResultDO<ResourceMonitorDetailDTO> getCpuMonitorDataList(ResMonitorDetailDTO dto) {
		ResultDO result = new ResultDO();
		String itemId = getMonitorItemId(dto.getMerchantId(),
				dto.getChannelNo(),Integer.parseInt(dto.getResourceType()));
		if(ValidateHelper.isEmpty(itemId)){
			result.setSuccess(false);
			result.setErrCode(MonitorErrorConstant.ITEM_ID_NOT_EXIT.getCode());
			result.setErrMsg(MonitorErrorConstant.ITEM_ID_NOT_EXIT.getMsg());
			return result;
		}
		int valueType = 0;
		if(StringUtils.equals(dto.getResourceType(),ResourceTypeEnum.CPU.getValue()+"")){
			valueType = ItemValueTypeEnum.CPU.getValue();
		}else if(StringUtils.equals(dto.getResourceType(),ResourceTypeEnum.DISK.getValue()+"")){
			valueType = ItemValueTypeEnum.DISK.getValue();
		}else{
			result.setSuccess(false);
			result.setErrCode(MonitorErrorConstant.RESOURCE_TYPE_NOT_SUPORT.getCode());
			result.setErrMsg(MonitorErrorConstant.RESOURCE_TYPE_NOT_SUPORT.getMsg());
			return result;
		}
		ResourceMonitorDetailDTO detailDto = new ResourceMonitorDetailDTO();
		if(StringUtils.equals(dto.getTimeType(), TimeTypeEnum.HOUR_24.getName())){
			int num = 24;
			//最新数据
			long lastedTimeFrom = (System.currentTimeMillis()-1000*60*60*25)/1000;
			long lastedTimeTill = System.currentTimeMillis()/1000;
			JSONArray array = getItemTrendList(itemId,num,valueType,lastedTimeFrom,lastedTimeTill);
			if(array==null){
				result.setSuccess(false);
				result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
				result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
				return result;
			}
			JSONArray retArray = convertCpuTrendArray(array,dto.getResourceType());
			detailDto.setMonitorDataList(retArray);
			//环比数据
			long timeFrom = (System.currentTimeMillis()-1000*60*60*49)/1000;
			long timeTill = (System.currentTimeMillis()-1000*60*60*25)/1000;
			JSONArray lastMonitorArray = getItemTrendList(itemId,num,valueType,timeFrom,timeTill);
			JSONArray lastRetArray = convertCpuTrendArray(lastMonitorArray,dto.getResourceType());
			detailDto.setLastMonitorDataList(lastRetArray);
			result.setData(detailDto);
			result.setSuccess(true);
		}else {
			int num = 60;

			JSONArray array = getItemListData(itemId,num,valueType,null,"DESC");
			if(array==null || array.size()==0){
				result.setSuccess(false);
				result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
				result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
				return result;
			}
			JSONArray monitorDataList = convertCpuMonitorArray(array,dto.getResourceType());
			detailDto.setMonitorDataList(monitorDataList);
			result.setData(detailDto);
			result.setSuccess(true);
		}

		return result;
	}

	private JSONArray convertCpuTrendArray(JSONArray array,String resourceType) {
		JSONArray retArray = new JSONArray();
		if(array!=null && array.size()>0){
			for(int i=0;i<array.size();i++){
				JSONObject obj = (JSONObject)array.get(i);
				JSONObject newObj = new JSONObject();
				newObj.put("time",obj.getString("clock"));
				String value = obj.getString("value_avg");
				if(StringUtils.equals(resourceType+"",ResourceTypeEnum.CPU.getValue()+"")){
					value = (new BigDecimal(Double.parseDouble(value)).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue())+"";
				}
				newObj.put("value",value);
				retArray.add(newObj);
			}
		}else{
			return array;
		}
		return retArray;
	}


	private JSONArray convertCpuMonitorArray(JSONArray array,String resourceType) {
		JSONArray retArray = new JSONArray();
		JSONObject[] sortedArray = new JSONObject[array.size()];
		logger.info("排序开始，arrary.size="+array.size());
		if(array!=null && array.size()>0){
			for(int i=0;i<array.size();i++){
				JSONObject obj = (JSONObject)array.get(i);
				JSONObject newObj = new JSONObject();
				newObj.put("time",obj.getString("clock"));
				String value = obj.getString("value");
				if(StringUtils.equals(resourceType+"",ResourceTypeEnum.CPU.getValue()+"")){
					value = (new BigDecimal(Double.parseDouble(value)).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue())+"";
				}
				newObj.put("value",value);
				retArray.add(newObj);
				sortedArray[array.size()-1-i] = newObj;
			}
		}else{
			return array;
		}

		logger.info("排序结束，arrary.size="+sortedArray.length);
		return JSON.parseArray(JSON.toJSONString(sortedArray));
	}

	private JSONArray getItemTrendList(String itemId,int num,int valueType,Long timeFrom,Long timeTill){
		JSONArray array = null;
		try{
			JSONObject resObj = zabbixClient.queryTrendByItemId(itemId,24,valueType,timeFrom,timeTill);
			array = resObj.getJSONArray("result");
		}catch (Exception e){
			logger.error("获取监控项数据异常，itemId="+itemId,e);
		}
		return array;
	}

	public ResultDO<CacheMonitorDetailDTO> getCacheMonitorData(MonitorBaseDTO dto) {
		long merchantId=dto.getMerchantId();
		String channelNo=dto.getChannelNo();
		ResultDO<CacheMonitorDetailDTO> resp=new ResultDO<CacheMonitorDetailDTO>();
		CacheMonitorDetailDTO cacheMonitorDetailDTO=new CacheMonitorDetailDTO();
		ResultDO<CacheStatisticsDTO> result = new ResultDO<CacheStatisticsDTO>();
		result=logStatisticsService.getChannelRedisUseCount(channelNo,merchantId);
		if (result.getData()==null){
			resp.setSuccess(false);
			resp.setErrMsg("查询数据为空");
		}
		cacheMonitorDetailDTO.setTodayNum(result.getData().getTodayCunt().longValue());
		cacheMonitorDetailDTO.setYesterdayNum(result.getData().getYesterdayCount().longValue());
		resp.setData(cacheMonitorDetailDTO);
		resp.setSuccess(true);
		return resp;
	}

	/**
	 * 图片监控详情数据获取
	 * @param dto
	 * @return
	 */
	public ResultDO<SpaceUseMonitorDetailDTO> getImgMonitorDetail(MonitorBaseDTO dto) {
		ResultDO<SpaceUseMonitorDetailDTO> result = new ResultDO<SpaceUseMonitorDetailDTO>();
		SelectLeftSourceQuery leftSourceQuery = new SelectLeftSourceQuery();
		leftSourceQuery.setMerchantId(dto.getMerchantId());
		leftSourceQuery.setChannelNo(dto.getChannelNo());
		leftSourceQuery.setType(DeductConstant.Image);
		ResultDO<ServiceLeftSource> leftSourceDO = accountService.selectLeftSource(leftSourceQuery);
		if(!leftSourceDO.isSuccess()||ValidateHelper.isEmpty(leftSourceDO.getData())){
			logger.error("图片资源账户信息不存在,merchantId="+dto.getMerchantId()+",channelNo="+dto.getChannelNo());
			result.setSuccess(false);
			result.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
			result.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
			return result;
		}
		ServiceLeftSource leftSource = leftSourceDO.getData();
		ResultDO<Integer> attachDO = videoService.queryImageSumSize(dto.getChannelNo());
		Integer sumSize = 0;
		if(attachDO.isSuccess()){
			sumSize = attachDO.getData();
		}
		Double totalSpace = leftSource.getTotalNum();
		totalSpace  = totalSpace*1024*1024;//转换成KB单位
		SpaceUseMonitorDetailDTO detailDTO = new SpaceUseMonitorDetailDTO();
		detailDTO.setAllSize(new BigDecimal(totalSpace).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
		detailDTO.setUsedSize(new BigDecimal(sumSize).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
		detailDTO.setUseRate(new BigDecimal(sumSize).divide(new BigDecimal(totalSpace))
				.multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
		logger.debug("sumSize="+sumSize+",totalSpace="+totalSpace+",usedSize="+detailDTO.getUsedSize()+",useRate="+detailDTO.getUseRate());
		result.setSuccess(true);
		result.setData(detailDTO);
		return result;
	}

	public ResultDO<ServerStatusDTO> getServerStatus(MonitorBaseDTO dto) {
		ResultDO resultdDO = new ResultDO();
		//获取虚拟机信息
		SourceVirtual sourceVirtual = new SourceVirtual();
		sourceVirtual.setMerchantId(dto.getMerchantId());
		sourceVirtual.setChannelNumber(dto.getChannelNo());
		ResultDO<List<SourceVirtual>> sourceVirtualListDO = sourceVirtualService.selectByDomainList(sourceVirtual);
		List<SourceVirtual> sourceVirtualList = null;
		if(sourceVirtualListDO.isSuccess()){
			sourceVirtualList = sourceVirtualListDO.getData();
			if(sourceVirtualList!=null && sourceVirtualList.size()==1){
				sourceVirtual = sourceVirtualList.get(0);
			}else{
				logger.error("主机信息不存在，merchantId="+dto.getMerchantId()
						+",channelId="+dto.getChannelNo());
				return null;
			}
		}else{
			logger.error("主机信息不存在，merchantId="+dto.getMerchantId()
					+",channelId="+dto.getChannelNo());
		}
		String hostName = sourceVirtual.getName();
		String itemKey = MonitorItemKeyConstant.TOMCAT_ITEM_KEY;
		String itemId = null;
		try{
			itemId = this.getItemId(hostName,itemKey);
		}catch (Exception e){
			logger.error("获取tomcat进程监控项失败",e);
		}

		if(ValidateHelper.isEmpty(itemId)){
			resultdDO.setSuccess(false);
			resultdDO.setErrCode(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getCode());
			resultdDO.setErrMsg(MonitorErrorConstant.NOT_GET_MONITOR_DATA.getMsg());
			return resultdDO;
		}

		String value = this.getItemCurrentData(itemId,ItemValueTypeEnum.TOMCAT.getValue(),ResourceTypeEnum.TOMCAT.getValue());

		if(!StringUtils.equals("1",value)){
			value = "0";
		}
		ServerStatusDTO statusDTO = new ServerStatusDTO();
		statusDTO.setStatus(value);
		resultdDO.setSuccess(true);
		resultdDO.setData(statusDTO);
		return resultdDO;
	}

	/**
	 * 数据库监控详情数据获取
	 * @param dto
	 * @return
	 */
	public ResultDO<SpaceUseMonitorDetailDTO> getDbMonitorDetail(MonitorBaseDTO dto) {
		ResultDO<SpaceUseMonitorDetailDTO> result = new ResultDO<SpaceUseMonitorDetailDTO>();

		//获取数据库总空间大小
		SourceDatabase sourceDatabase = new SourceDatabase();
		sourceDatabase.setMerchantId(dto.getMerchantId());
		sourceDatabase.setChannelNo(dto.getChannelNo());
		ResultDO<List<SourceDatabase>> databaseDO = sourceDatabaseService.selectByDomainList(sourceDatabase);
		SourceDatabase database = null;
		if(!databaseDO.isSuccess()||ValidateHelper.isEmpty(databaseDO.getData())||databaseDO.getData().size()==0){
			result.setSuccess(false);
			result.setErrCode(MonitorErrorConstant.DATABASE_NOT_EXIT.getCode());
			result.setErrMsg(MonitorErrorConstant.DATABASE_NOT_EXIT.getMsg());
			return result;
		}else{
			database = databaseDO.getData().get(0);
		}
		Long totalSpace = database.getSpace();

		//获取当前数据库已使用大小
		String dbUsedSize = null;
		ResultDO dbCurrentDO = this.getDBUsesNum(dto,database);
		if(dbCurrentDO.isSuccess()){
			dbUsedSize = (String)dbCurrentDO.getData();
		}else{
			dbUsedSize = "0";
			logger.error("获取当前数据库使用空间失败,merchantNo="+dto.getMerchantId()
					+",channelNo="+dto.getChannelNo());
		}

		SpaceUseMonitorDetailDTO detailDTO = new SpaceUseMonitorDetailDTO();
		totalSpace = totalSpace*1024*1024;
		detailDTO.setAllSize(totalSpace+"");
		detailDTO.setUsedSize(dbUsedSize);
		detailDTO.setUseRate(new BigDecimal(dbUsedSize).divide(new BigDecimal(totalSpace))
				.multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
		logger.debug("totalSpace="+totalSpace+",dbUsedSize="+dbUsedSize+",useRate="+detailDTO.getUseRate());
		result.setData(detailDTO);
		return result;
	}

	public ResultDO<SpaceUseMonitorDetailDTO> getDiskMonitorDetail(MonitorBaseDTO dto) {
		ResultDO<SpaceUseMonitorDetailDTO> result=new ResultDO<SpaceUseMonitorDetailDTO>();
		//获取磁盘空间使用大小
		ResultDO diskUseDo = getDiskUsesNum(dto);
		SpaceUseMonitorDetailDTO spaceUse =new SpaceUseMonitorDetailDTO();
		spaceUse.setUsedSize((String)diskUseDo.getData());
		//获取虚拟机信息
		SourceVirtual sourceVirtual = new SourceVirtual();
		sourceVirtual.setMerchantId(dto.getMerchantId());
		sourceVirtual.setChannelNumber(dto.getChannelNo());
		ResultDO<List<SourceVirtual>> sourceVirtualListDO = sourceVirtualService.selectByDomainList(sourceVirtual);
		List<SourceVirtual> sourceVirtualList = null;
		if(sourceVirtualListDO.isSuccess()){
			sourceVirtualList = sourceVirtualListDO.getData();
			if(sourceVirtualList!=null && sourceVirtualList.size()==1){
				sourceVirtual = sourceVirtualList.get(0);
			}else{
				logger.error("主机信息不存在，merchantId="+dto.getMerchantId()+",channelNo="+dto.getChannelNo());
				return null;
			}
		}
		String UseRate="";
		if(sourceVirtual!=null){
			spaceUse.setAllSize(sourceVirtual.getRom());
			if(diskUseDo.isSuccess()){
				UseRate=new BigDecimal((String)diskUseDo.getData()).divide(new BigDecimal(sourceVirtual.getRom()).multiply(new BigDecimal("10737418.24"))).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
			}else {
				UseRate="0";
			}
		}
		spaceUse.setUseRate(UseRate);
		result.setData(spaceUse);
		result.setSuccess(true);
		return result;
	}
}