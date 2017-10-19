package com.shfc.cloud.monitor.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cache.domain.CacheRecord.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/31 14:34
 * version v1.0.0
 */
public class CacheRecord extends BaseBean {
    /**
     * 商户ID
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
     * 操作类型 1：添加 2:查询 3:删除
     */
    private String type;

    /**
     * 状态 0:失败 1：成功
     */
    private String status;

    /**
     * 内容
     */
    private String content;

    /**
     * 获取商户ID
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户ID
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取频道号
     *
     * @return channel_no
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 设置频道号
     *
     * @param channelNo
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    /**
     * 获取缓存key
     *
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置缓存key
     *
     * @param key
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 获取操作类型 1：添加 2:查询 3:删除
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置操作类型 1：添加 2:查询 3:删除
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取状态 0:失败 1：成功
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态 0:失败 1：成功
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取内容
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}