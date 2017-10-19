package com.shfc.sms.domain;

import com.shfc.common.httpbean.BaseBean;

import java.math.BigDecimal;

/**
 * @Package: com.shfc.sms.domain.SmsRecord.java
 * @Description: 短信单条发送记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/03/03 16:58
 * version v1.0.0
 */
public class SmsRecord extends BaseBean {
    /**
     * 商户id
     */
    private Long merchantId;
    /**
     * 频道号
     */
    private String channelNo;
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 短信通道收取费用
     */
    private BigDecimal smsFee;

    /**
     * 短信通道计费单位"RMB"
     */
    private String smsUnit;

    /**
     * 计费条数
     */
    private Integer sendCount;

    /**
     * 发送状态(0-成功 1-失败)
     */
    private Integer sendStatus;

    /**
     * 短信通道短信id
     */
    private Long channelSid;

    /**
     * 商户短信模板id
     */
    private Long templateId;

    /**
     * 短信通道(0-云片)
     */
    private Integer channel;

    /**
     * 短信记录来源（0单条，其他数值来源于批量ID）
     */
    private Long source;

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

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    /**
     * 获取手机号
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取发送内容
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置发送内容
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取短信通道收取费用
     *
     * @return sms_fee
     */
    public BigDecimal getSmsFee() {
        return smsFee;
    }

    /**
     * 设置短信通道收取费用
     *
     * @param smsFee
     */
    public void setSmsFee(BigDecimal smsFee) {
        this.smsFee = smsFee;
    }

    /**
     * 获取短信通道计费单位"RMB"
     *
     * @return sms_unit
     */
    public String getSmsUnit() {
        return smsUnit;
    }

    /**
     * 设置短信通道计费单位"RMB"
     *
     * @param smsUnit
     */
    public void setSmsUnit(String smsUnit) {
        this.smsUnit = smsUnit == null ? null : smsUnit.trim();
    }

    /**
     * 获取计费条数
     *
     * @return send_count
     */
    public Integer getSendCount() {
        return sendCount;
    }

    /**
     * 设置计费条数
     *
     * @param sendCount
     */
    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    /**
     * 获取发送状态(0-成功 1-失败)
     *
     * @return send_status
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 设置发送状态(0-成功 1-失败)
     *
     * @param sendStatus
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 获取短信通道短信id
     *
     * @return channelSid
     */
    public Long getChannelSid() {
        return channelSid;
    }

    /**
     * 设置短信通道短信id
     *
     * @param channelSid
     */
    public void setChannelSid(Long channelSid) {
        this.channelSid = channelSid;
    }

    /**
     * 获取商户短信模板id
     *
     * @return template_id
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * 设置商户短信模板id
     *
     * @param templateId
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
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

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    /**
     * @Title toString
     * @Author xiehb
     * @Date 2017/03/03 16:58
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
        sb.append(", mobile=").append(mobile);
        sb.append(", content=").append(content);
        sb.append(", smsFee=").append(smsFee);
        sb.append(", smsUnit=").append(smsUnit);
        sb.append(", sendCount=").append(sendCount);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", channelSid=").append(channelSid);
        sb.append(", templateId=").append(templateId);
        sb.append(", channel=").append(channel);
        sb.append(", source=").append(source);
        sb.append("]");
        return sb.toString();
    }
}