package com.shfc.cloud.monitor.dto;


import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.monitor.dto.ResourceMonitorDetailDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/23 20:42
 * version V1.0.0
 */
public class ResourceMonitorDetailDTO  implements Serializable {

	private JSONArray monitorDataList;

	private JSONArray lastMonitorDataList;

	public JSONArray getMonitorDataList() {
		return monitorDataList;
	}

	public void setMonitorDataList(JSONArray monitorDataList) {
		this.monitorDataList = monitorDataList;
	}

	public JSONArray getLastMonitorDataList() {
		return lastMonitorDataList;
	}

	public void setLastMonitorDataList(JSONArray lastMonitorDataList) {
		this.lastMonitorDataList = lastMonitorDataList;
	}
}
