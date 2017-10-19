package com.shfc.cloud.sms.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.sms.dto.SendVoiceWebDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/30 11:34
 * version V1.0.0
 */
@ApiModel(value = "SendVoiceWebDTO")
public class SendVoiceWebDTO implements Serializable {
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private Long templateId;//商户短信模板id
    private String mobile;//手机号
    private String code;//数字验证码

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
