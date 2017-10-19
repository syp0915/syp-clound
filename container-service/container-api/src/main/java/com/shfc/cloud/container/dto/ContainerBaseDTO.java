package com.shfc.cloud.container.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.dto.BaseDTO
 * @Description: base dto
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/21 16:01
 * version V1.0.0
 */
public class ContainerBaseDTO implements Serializable{
	/**
	 * 商户号
	 */
	private Long merchantId;

	/**
	 * 频道号
	 */
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
