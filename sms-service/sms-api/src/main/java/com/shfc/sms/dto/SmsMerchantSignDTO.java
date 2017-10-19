package com.shfc.sms.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.sms.dto.SmsMerchantSignDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/6 上午10:51
 * version V1.0.0
 */
public class SmsMerchantSignDTO implements Serializable{
    private Long merchantId;//商户id

    private String channelNo;//频道号

    private Long signId;//签名id

    private String oldSign;//旧签名

    private String sign;//签名内容

    private Integer notify;//是否短信通知结果(0-否1-是）

    private Integer applyVip;//是否申请专用通道(0-否1-是）

    private Integer onlyGlobal;//是否仅发国际短信(0-否1-是）

    private String industryType;//所属行业

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

    public String getOldSign() {
        return oldSign;
    }

    public void setOldSign(String oldSign) {
        this.oldSign = oldSign;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getNotify() {
        return notify;
    }

    public void setNotify(Integer notify) {
        this.notify = notify;
    }

    public Integer getApplyVip() {
        return applyVip;
    }

    public void setApplyVip(Integer applyVip) {
        this.applyVip = applyVip;
    }

    public Integer getOnlyGlobal() {
        return onlyGlobal;
    }

    public void setOnlyGlobal(Integer onlyGlobal) {
        this.onlyGlobal = onlyGlobal;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }
}
