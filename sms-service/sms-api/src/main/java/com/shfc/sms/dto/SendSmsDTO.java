package com.shfc.sms.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.sms.dto.SingleSmsDTO
 * @Description: 发送单条短信DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/3 17:51
 * version V1.0.0
 */
public class SendSmsDTO implements Serializable {
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private Long templateId;//商户短信模板id
    private String mobile;//发送手机号
    private String text;//短信内容


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

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SendSmsDTO{" +
                "merchantId=" + merchantId +
                ", templateId=" + templateId +
                ", mobile='" + mobile + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
