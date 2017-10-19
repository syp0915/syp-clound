package com.shfc.cloud.gateway.domain;

import com.shfc.common.httpbean.BaseBean;

import java.io.Serializable;

/**
 * @Package: com.shfc.cloud.gateway.domain.GatewayInterfaceAuth.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/27 15:54
 * version v1.0.0
 */
public class GatewayInterfaceAuth implements Serializable {
    private static final long serialVersionUID = -7796209422786542822L;
    private Long merchantId;

    private String channelNo;

    private String status;

    private Integer validity;

    private String startDate;

    private String endDate;
    private Long id;
    private Long creater;
    private String createTime;
    private Long modifier;
    private String modifyTime;
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return channel_no
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * @param channelNo
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return validity
     */
    public Integer getValidity() {
        return validity;
    }

    /**
     * @param validity
     */
    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    /**
     * @return start_date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * @return end_date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }
}