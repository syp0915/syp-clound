package com.shfc.sms.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.sms.domain.SmsVoice.java
 * @Description: 语音发送记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/01 14:18
 * version v1.0.0
 */
public class SmsVoice extends BaseBean {
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
     * 验证码-支持4~6位阿拉伯数字
     */
    private String smsCode;

    /**
     * 发送状态(0-成功 1-失败)
     */
    private Integer sendStatus;

    /**
     * 语音通道收取费用
     */
    private BigDecimal smsFee;

    /**
     * 计费条数
     */
    private Integer sendCount;

    /**
     * 短信通道短信id
     */
    private String sid;

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
     * 获取验证码-支持4~6位阿拉伯数字
     *
     * @return sms_code
     */
    public String getSmsCode() {
        return smsCode;
    }

    /**
     * 设置验证码-支持4~6位阿拉伯数字
     *
     * @param smsCode
     */
    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode == null ? null : smsCode.trim();
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
     * 获取语音通道收取费用
     *
     * @return sms_fee
     */
    public BigDecimal getSmsFee() {
        return smsFee;
    }

    /**
     * 设置语音通道收取费用
     *
     * @param smsFee
     */
    public void setSmsFee(BigDecimal smsFee) {
        this.smsFee = smsFee;
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
     * 获取短信通道短信id
     *
     * @return sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * 设置短信通道短信id
     *
     * @param sid
     */
    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
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
        sb.append(", mobile=").append(mobile);
        sb.append(", smsCode=").append(smsCode);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", smsFee=").append(smsFee);
        sb.append(", sendCount=").append(sendCount);
        sb.append(", sid=").append(sid);
        sb.append(", channel=").append(channel);
        sb.append("]");
        return sb.toString();
    }
}