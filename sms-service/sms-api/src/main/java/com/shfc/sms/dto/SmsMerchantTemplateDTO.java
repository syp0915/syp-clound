package com.shfc.sms.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 短信模板请求内容
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-02 09:54
 **/
public class SmsMerchantTemplateDTO implements Serializable {
    private static final long serialVersionUID = -2026589958021833856L;
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private Long signId;//商户签名id
    private Long tplId;//模板id，主键ID
    private String tplContent;//模板内容
    private Long channelTplId;//通道模板ID

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

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getSignId() {
        return signId;
    }

    public void setSignId(Long signId) {
        this.signId = signId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getChannelTplId() {
        return channelTplId;
    }

    public void setChannelTplId(Long channelTplId) {
        this.channelTplId = channelTplId;
    }
}
