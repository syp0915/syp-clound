package com.shfc.sms.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.sms.domain.SmsBatchRecord.java
 * @Description: 短信批量发送记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/03/03 16:58
 * version v1.0.0
 */
public class SmsBatchRecord extends BaseBean {
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
     * 批量发送成功总条数
     */
    private Integer totalCount;

    /**
     * 批量发送抽取总费用
     */
    private BigDecimal totalFee;

    /**
     * 短信通道计费单位"RMB"
     */
    private String smsUnit;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 0批量发送相同内容，1批量发送不同内容
     */
    private Integer batchType;

    /**
     * 发送状态(0-成功 1-失败)
     */
    private Integer sendStatus;

    /**
     * 商户短信模板id
     */
    private Long templateId;

    /**
     * 短信通道(0-云片)
     */
    private Integer channel;

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
     * 获取批量发送成功总条数
     *
     * @return total_count
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置批量发送成功总条数
     *
     * @param totalCount
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取批量发送抽取总费用
     *
     * @return total_fee
     */
    public BigDecimal getTotalFee() {
        return totalFee;
    }

    /**
     * 设置批量发送抽取总费用
     *
     * @param totalFee
     */
    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
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
     * 获取0批量发送相同内容，1批量发送不同内容
     *
     * @return batch_type
     */
    public Integer getBatchType() {
        return batchType;
    }

    /**
     * 设置0批量发送相同内容，1批量发送不同内容
     *
     * @param batchType
     */
    public void setBatchType(Integer batchType) {
        this.batchType = batchType;
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
        sb.append(", totalCount=").append(totalCount);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", smsUnit=").append(smsUnit);
        sb.append(", content=").append(content);
        sb.append(", batchType=").append(batchType);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", templateId=").append(templateId);
        sb.append(", channel=").append(channel);
        sb.append("]");
        return sb.toString();
    }
}