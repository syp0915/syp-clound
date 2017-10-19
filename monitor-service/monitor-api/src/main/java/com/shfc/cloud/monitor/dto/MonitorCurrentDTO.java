package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.monitor.dto.MonitorCurrentDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/22 20:42
 * version V1.0.0
 */
public class MonitorCurrentDTO  implements Serializable {

	/**
	 * 频道编号
	 */
	private String channelId;
	/**
	 * CPU使用率
	 */
	private String cpuUseRate;

	/**
	 * 图片空间使用率
	 */
	private String imgUseRate;

	/**
	 * 缓存调用次数
	 */
	private String catchNum;

	/**
	 * 数据库占用
	 */
	private String dbUseRate;

	/**
	 * 磁盘空间占用
	 */
	private String diskUseSize;

	public String getCpuUseRate() {
		return cpuUseRate;
	}

	public void setCpuUseRate(String cpuUseRate) {
		this.cpuUseRate = cpuUseRate;
	}

	public String getImgUseRate() {
		return imgUseRate;
	}

	public void setImgUseRate(String imgUseRate) {
		this.imgUseRate = imgUseRate;
	}

	public String getCatchNum() {
		return catchNum;
	}

	public void setCatchNum(String catchNum) {
		this.catchNum = catchNum;
	}

	public String getDbUseRate() {
		return dbUseRate;
	}

	public void setDbUseRate(String dbUseRate) {
		this.dbUseRate = dbUseRate;
	}

	public String getDiskUseSize() {
		return diskUseSize;
	}

	public void setDiskUseSize(String diskUseSize) {
		this.diskUseSize = diskUseSize;
	}
}
