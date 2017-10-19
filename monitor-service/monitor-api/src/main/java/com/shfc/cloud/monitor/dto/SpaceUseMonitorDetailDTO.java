package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.monitor.dto.SpaceUseMonitorDetailDTO
 * @Description: 空间使用详情监控DTO（图片空间、数据库空间）
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/24 11:21
 * version V1.0.0
 */
public class SpaceUseMonitorDetailDTO implements Serializable {

	/**
	 * 已使用大小
	 */
	private String usedSize;

	/**
	 * 总大小
	 */
	private String allSize;

	/**
	 * 使用率
	 */
	private String useRate;

	public String getUsedSize() {
		return usedSize;
	}

	public void setUsedSize(String usedSize) {
		this.usedSize = usedSize;
	}

	public String getAllSize() {
		return allSize;
	}

	public void setAllSize(String allSize) {
		this.allSize = allSize;
	}

	public String getUseRate() {
		return useRate;
	}

	public void setUseRate(String useRate) {
		this.useRate = useRate;
	}
}
