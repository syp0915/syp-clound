package com.shfc.cloud.monitor.dto;

/**
 * @Package com.shfc.apistore.api.cache.dto.CacheRecordWebDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhanghz
 * @date 2017/3/31 14:08
 * version V1.0.0
 */
public class CacheRecordDTO {

	/**
	 * 商户号
	 */
	private Long merchantId;

	/**
	 * 频道号
	 */
	private String channelNo;

	/**
	 * 缓存key
	 */
	private String key;

	/**
	 * 缓存内容
	 */
	private String content;

	/**
	 * 操作类型
	 */
	private String type;

	/**
	 * 状态
	 */
	private String status;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
