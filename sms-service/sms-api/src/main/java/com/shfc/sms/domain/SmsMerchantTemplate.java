package com.shfc.sms.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.sms.domain.SmsMerchantTemplate.java
 * @Description: 商户短信模板
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/01 14:18
 * version v1.0.0
 */
public class SmsMerchantTemplate extends BaseBean {
    /**
     * 商户id
     */
    private Long merchantId;
    /**
     * 频道号
     */
    private String channelNo;

    /**
     * 商户签名id
     */
    private Long smsSignId;

    /**
     * 模板内容
     */
    private String content;

    /**
     * 审核状态(0-审核中1-审核通过 2-审核失败 ）
     */
    private Integer auditStatus;

    /**
     * 审核未通过的原因
     */
    private String reason;

    /**
     * 短信通道(0-云片)
     */
    private Integer channel;

    /**
     * 通道模板id
     */
    private Long channelTplId;

    /**
     * 是否删除(0-否 1-是)
     */
    private Integer isDelete;

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
     * 获取商户签名id
     *
     * @return sms_sign_id
     */
    public Long getSmsSignId() {
        return smsSignId;
    }

    /**
     * 设置商户签名id
     *
     * @param smsSignId
     */
    public void setSmsSignId(Long smsSignId) {
        this.smsSignId = smsSignId;
    }

    /**
     * 获取模板内容
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置模板内容
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取审核状态(0-审核中1-审核通过 2-审核失败 ）
     *
     * @return audit_status
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态(0-审核中1-审核通过 2-审核失败 ）
     *
     * @param auditStatus
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
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
     * 获取通道模板id
     *
     * @return channel_tpl_id
     */
    public Long getChannelTplId() {
        return channelTplId;
    }

    /**
     * 设置通道模板id
     *
     * @param channelTplId
     */
    public void setChannelTplId(Long channelTplId) {
        this.channelTplId = channelTplId;
    }

    /**
     * 获取是否删除(0-否 1-是)
     *
     * @return is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除(0-否 1-是)
     *
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
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
        sb.append(", smsSignId=").append(smsSignId);
        sb.append(", content=").append(content);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", reason=").append(reason);
        sb.append(", channel=").append(channel);
        sb.append(", channelTplId=").append(channelTplId);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}