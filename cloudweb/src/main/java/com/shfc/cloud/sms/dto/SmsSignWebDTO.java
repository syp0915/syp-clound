package com.shfc.cloud.sms.dto;

import io.swagger.annotations.ApiModel;

import java.awt.*;
import java.io.Serializable;

/**
 * @Package com.shfc.cloud.sms.dto.AddSignWebDTO
 * @Description: 添加签名的webDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/30 14:22
 * version V1.0.0
 */
@ApiModel(value = "AddSignWebDTO")
public class SmsSignWebDTO implements Serializable {
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private Long signId;//签名ID
    private String sign;//签名内容
    private String oldSign;//老的签名
    /*private Integer notify;//是否短信通知结果(0-否1-是）
    private Integer applyVip;//是否申请专用通道(0-否1-是）
    private Integer onlyGlobal;//是否仅发国际短信(0-否1-是）*/
    private String industryType;//所属行业

    public Long getSignId() {
        return signId;
    }

    public void setSignId(Long signId) {
        this.signId = signId;
    }

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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getOldSign() {
        return oldSign;
    }

    public void setOldSign(String oldSign) {
        this.oldSign = oldSign;
    }
}
