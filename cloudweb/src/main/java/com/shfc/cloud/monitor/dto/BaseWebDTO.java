package com.shfc.cloud.monitor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.monitor.dto.MonitorDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/29 15:36
 * version V1.0.0
 */
@ApiModel(value = "BaseWebDTO")
public class BaseWebDTO {

	@ApiModelProperty(value = "商户ID",required = true)
	private Long merchantId;

	@ApiModelProperty(value = "频道号",required = true)
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
