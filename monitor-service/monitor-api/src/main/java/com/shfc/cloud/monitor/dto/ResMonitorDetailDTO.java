package com.shfc.cloud.monitor.dto;

/**
 * @Package com.shfc.cloud.monitor.dto.ResMonitorDetailDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/22 20:24
 * version V1.0.0
 */
public class ResMonitorDetailDTO extends MonitorBaseDTO {

	/**
	 * 资源类型
	 */
	private String resourceType;

	/**
	 * 监控时间类型
	 */
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
