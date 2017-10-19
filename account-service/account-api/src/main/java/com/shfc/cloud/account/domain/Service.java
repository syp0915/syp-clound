package com.shfc.cloud.account.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.account.domain.Service.java
 * @Description: 商家已开通服务表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 15:30
 * version v1.0.0
 */
public class Service extends BaseBean {
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 频道id
     */
    private Long channelId;

    /**
     * 频道编号
     */
    private String channelNumber;

    /**
     * 服务id
     */
    private Long typeId;

    /**
     * 已开通服务名称
     */
    private String typeName;

    /**
     * 是否开通
     */
    private Boolean isOpen;

    /**
     * 获取商户id
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户id
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取频道id
     *
     * @return channel_id
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 设置频道id
     *
     * @param channelId
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取频道编号
     *
     * @return channel_number
     */
    public String getChannelNumber() {
        return channelNumber;
    }

    /**
     * 设置频道编号
     *
     * @param channelNumber
     */
    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber == null ? null : channelNumber.trim();
    }

    /**
     * 获取服务id
     *
     * @return type_id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置服务id
     *
     * @param typeId
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取已开通服务名称
     *
     * @return type_name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置已开通服务名称
     *
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 获取是否开通
     *
     * @return is_open
     */
    public Boolean getIsOpen() {
        return isOpen;
    }

    /**
     * 设置是否开通
     *
     * @param isOpen
     */
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }
}