package com.shfc.cloud.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.sms.dto.SendSmsDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/29 19:41
 * version V1.0.0
 */
@ApiModel(value = "SendSmsWebDTO")
public class SendSmsWebDTO implements Serializable {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;//商户id
    @ApiModelProperty(value = "频道号", required = true)
    private String channelNo;//频道号
    @ApiModelProperty(value = "商户短信模板id", required = true)
    private Long templateId;//商户短信模板id
    @ApiModelProperty(value = "发送手机号", required = true)
    private String mobile;//发送手机号
    @ApiModelProperty(value = "短信内容", required = true)
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
}
