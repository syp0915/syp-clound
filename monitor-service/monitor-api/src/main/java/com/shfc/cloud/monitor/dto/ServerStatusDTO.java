package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.monitor.dto.ServerStatusDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/30 16:42
 * version V1.0.0
 */
public class ServerStatusDTO implements Serializable {

	/**
	 * 运行状态
	 */
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
