package com.shfc.cloud.monitor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.monitor.dto.ResMonitorDetailDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/22 20:24
 * version V1.0.0
 */
@ApiModel(value = "ResMonitorDetailWebDTO")
public class ResMonitorDetailWebDTO extends BaseWebDTO {

	/**
	 * 资源类型
	 */
	@ApiModelProperty(value = "资源类型", required = true)
	private String resourceType;

	/**
	 * 监控时间类型
	 */
	@ApiModelProperty(value = "时间类型（60m/24h）", required = true)
	private String timeType;

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
}
