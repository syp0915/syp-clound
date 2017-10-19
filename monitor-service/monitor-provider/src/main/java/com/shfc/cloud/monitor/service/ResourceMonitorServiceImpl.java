package com.shfc.cloud.monitor.service;

import com.shfc.cloud.cloudbase.domain.SourceVirtual;
import com.shfc.cloud.monitor.dto.*;
import com.shfc.cloud.monitor.manager.ResourceMonitorManager;
import com.shfc.common.base.Logger;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.cloud.monitor.service.ResourceMonitorServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/22 20:34
 * version V1.0.0
 */
@Service
public class ResourceMonitorServiceImpl implements ResourceMonitorService {

	@Autowired(required = false)
	private ResourceMonitorManager resourceMonitorManager;

	@Override
	public ResultDO<MonitorCurrentDTO> getLastedMonitorData(MonitorBaseDTO dto) {
		ResultDO<MonitorCurrentDTO> result = resourceMonitorManager.getLastedMonitorData(dto);
		return result;
	}

	@Override
	public ResultDO<ResourceMonitorDetailDTO> getResourceMonitorDetail(ResMonitorDetailDTO dto) {
		ResultDO<ResourceMonitorDetailDTO> result = resourceMonitorManager.getCpuMonitorDataList(dto);
		return result;
	}

	@Override
	public ResultDO<CacheMonitorDetailDTO> getCacheMonitorDetail(MonitorBaseDTO dto) {
		ResultDO<CacheMonitorDetailDTO> result = resourceMonitorManager.getCacheMonitorData(dto);

		return result;
	}

	@Override
	public ResultDO getImgMonitorDetail(MonitorBaseDTO dto) {
		ResultDO<SpaceUseMonitorDetailDTO> result = resourceMonitorManager.getImgMonitorDetail(dto);
		return result;
	}

	@Override
	public ResultDO<SpaceUseMonitorDetailDTO> getDBMonitorDetail(MonitorBaseDTO dto) {
		ResultDO<SpaceUseMonitorDetailDTO> result = resourceMonitorManager.getDbMonitorDetail(dto);
		return result;
	}

	@Override
	public ResultDO<ServerStatusDTO> getServerStatus(MonitorBaseDTO dto) {
		ResultDO<ServerStatusDTO> result = resourceMonitorManager.getServerStatus(dto);
		return result;
	}

	@Override
	public ResultDO<SpaceUseMonitorDetailDTO> getDiskMonitorDetail(MonitorBaseDTO dto) {
		ResultDO<SpaceUseMonitorDetailDTO> result = resourceMonitorManager.getDiskMonitorDetail(dto);
		return result;
	}
}
