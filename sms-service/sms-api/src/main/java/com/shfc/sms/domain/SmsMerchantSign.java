package com.shfc.sms.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.sms.domain.SmsMerchantSign.java
 * @Description: 商户签名
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/01 14:18
 * version v1.0.0
 */
public class SmsMerchantSign extends BaseBean {
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 频道号
     */
    private String channelNo;

    /**
     * 商户签名
     */
    private String merchantSign;

    /**
     * 签名状态(0-审核中 1-审核失败 2-审核通过）
     */
    private Integer signStatus;

    /**
     * 审核未通过的原因
     */
    private String reason;

    /**
     * 短信通道(0-云片)
     */
    private Integer channel;

    /**
     * 是否为专用通道(0-否1-是）
     */
    private Integer isVip;

    /**
     * 行业类型
     */
    private String industryType;

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
        this.channelNo = channelNo;
    }

    /**
     * 获取商户签名
     *
     * @return merchant_sign
     */
    public String getMerchantSign() {
        return merchantSign;
    }

    /**
     * 设置商户签名
     *
     * @param merchantSign
     */
    public void setMerchantSign(String merchantSign) {
        this.merchantSign = merchantSign == null ? null : merchantSign.trim();
    }

    /**
     * 获取签名状态(0-审核中 1-审核失败 2-审核通过）
     *
     * @return sign_status
     */
    public Integer getSignStatus() {
        return signStatus;
    }

    /**
     * 设置签名状态(0-审核中 1-审核失败 2-审核通过）
     *
     * @param signStatus
     */
    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    /**
     * 获取审核未通过的原因
     *
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置审核未通过的原因
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 获取短信通道(0-云片)
     *
     * @return channel
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * 设置短信通道(0-云片)
     *
     * @param channel
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * 获取是否为专用通道(0-否1-是）
     *
     * @return is_vip
     */
    public Integer getIsVip() {
        return isVip;
    }

    /**
     * 设置是否为专用通道(0-否1-是）
     *
     * @param isVip
     */
    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    /**
     * 获取行业类型
     *
     * @return industry_type
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * 设置行业类型
     *
     * @param industryType
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType == null ? null : industryType.trim();
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/03/01 14:18
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantSign=").append(merchantSign);
        sb.append(", channelNo=").append(channelNo);
        sb.append(", signStatus=").append(signStatus);
        sb.append(", reason=").append(reason);
        sb.append(", channel=").append(channel);
        sb.append(", isVip=").append(isVip);
        sb.append(", industryType=").append(industryType);
        sb.append("]");
        return sb.toString();
    }
}