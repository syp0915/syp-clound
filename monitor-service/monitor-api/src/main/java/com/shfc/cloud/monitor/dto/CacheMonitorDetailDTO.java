package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.monitor.dto.CacheMonitorDetailDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/24 11:05
 * version V1.0.0
 */
public class CacheMonitorDetailDTO implements Serializable {

	private static final long serialVersionUID = 7545380470404199622L;
	/**
	 * 昨日调用次数
	 */
	private Long yesterdayNum;

	/**
	 * 今日调用次数
	 */
	private Long todayNum;

	/**
	 * 总调用次数
	 * @return
     */
	private Long totalCount;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getYesterdayNum() {
		return yesterdayNum;
	}

	public void setYesterdayNum(Long yesterdayNum) {
		this.yesterdayNum = yesterdayNum;
	}

	public Long getTodayNum() {
		return todayNum;
	}

	public void setTodayNum(Long todayNum) {
		this.todayNum = todayNum;
	}
}
