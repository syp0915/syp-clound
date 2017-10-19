package com.shfc.cloud.account.query;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.account.query.CheckMerchantQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/29 14:00
 * version V1.0.0
 */
public class CheckMerchantQuery implements Serializable {
    private Long merchantId;//商户ID
    private String channelNo;//频道号

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
}
