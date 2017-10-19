package com.shfc.cloud.account.query;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.account.query
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 10:45
 * version V1.0.0
 */
public class UserInfoQuery implements Serializable {

    private Long merchantId;//商户ID
    private String merchantNo;//商户号
    private String channelNo;//频道号

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}
