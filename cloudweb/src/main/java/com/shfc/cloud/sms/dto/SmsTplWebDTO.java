package com.shfc.cloud.sms.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.sms.dto.SmsTplWebDTO
 * @Description: 短信模板webDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/30 14:34
 * version V1.0.0
 */
@ApiModel(value = "SmsTplWebDTO")
public class SmsTplWebDTO implements Serializable {
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private Long signId;//商户签名id
    private Long tplId;//模板id，主键ID
    private String tplContent;//模板内容

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

    public Long getSignId() {
        return signId;
    }

    public void setSignId(Long signId) {
        this.signId = signId;
    }

    public Long getTplId() {
        return tplId;
    }

    public void setTplId(Long tplId) {
        this.tplId = tplId;
    }

    public String getTplContent() {
        return tplContent;
    }

    public void setTplContent(String tplContent) {
        this.tplContent = tplContent;
    }
}
