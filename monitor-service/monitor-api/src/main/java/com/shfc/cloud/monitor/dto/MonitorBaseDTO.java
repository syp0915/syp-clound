package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.monitor.dto.MonitorBaseDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/22 20:13
 * version V1.0.0
 */
public class MonitorBaseDTO implements Serializable{

	private Long merchantId;

	private String channelNo;

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}
}
