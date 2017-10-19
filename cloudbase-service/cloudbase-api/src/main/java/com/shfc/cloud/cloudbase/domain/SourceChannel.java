package com.shfc.cloud.cloudbase.domain;

import com.shfc.common.httpbean.BaseBean;

import java.util.Date;

/**
 * @Package: com.shfc.basis.domain.SourceChannel.java
 * @Description: 资源——频道表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 16:52
 * version v1.0.0
 */
public class SourceChannel extends BaseBean {
    /**
     * 频道号
     */
    private String channelNumber;

    /**
     * 频道播放链接
     */
    private String channerUrl;

    /**
     * 合同id
     */
    private Long contractId;

    /**
     * 合同号
     */
    private String contractNumber;

    /**
     * 所属商户id
     */
    private Long merchantId;

    private String merchantNumber;

    /**
     * 频道名
     */
    private String name;

    /**
     * 频道类型 1-新闻 2-教育 3-文艺 4-服务
     */
    private Integer type;

    /**
     * 配置状态 0-待处理 1-配置中 2-已开通
     */
    private Integer status;

    /**
     * 开通时间
     */
    private Date openTime;

    /**
     * 失效时间
     */
    private Date endTime;

    /**
     * 获取频道号
     *
     * @return channel_number
     */
    public String getChannelNumber() {
        return channelNumber;
    }

    /**
     * 设置频道号
     *
     * @param channelNumber
     */
    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber == null ? null : channelNumber.trim();
    }

    /**
     * 获取频道播放链接
     *
     * @return channer_url
     */
    public String getChannerUrl() {
        return channerUrl;
    }

    /**
     * 设置频道播放链接
     *
     * @param channerUrl
     */
    public void setChannerUrl(String channerUrl) {
        this.channerUrl = channerUrl == null ? null : channerUrl.trim();
    }

    /**
     * 获取合同id
     *
     * @return contract_id
     */
    public Long getContractId() {
        return contractId;
    }

    /**
     * 设置合同id
     *
     * @param contractId
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * 获取合同号
     *
     * @return contract_number
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * 设置合同号
     *
     * @param contractNumber
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    /**
     * 获取所属商户id
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置所属商户id
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return merchant_number
     */
    public String getMerchantNumber() {
        return merchantNumber;
    }

    /**
     * @param merchantNumber
     */
    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber == null ? null : merchantNumber.trim();
    }

    /**
     * 获取频道名
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置频道名
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取频道类型 1-新闻 2-教育 3-文艺 4-服务
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置频道类型 1-新闻 2-教育 3-文艺 4-服务
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取配置状态 0-待处理 1-配置中 2-已开通
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置配置状态 0-待处理 1-配置中 2-已开通
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取开通时间
     *
     * @return open_time
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 设置开通时间
     *
     * @param openTime
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取失效时间
     *
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置失效时间
     *
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}