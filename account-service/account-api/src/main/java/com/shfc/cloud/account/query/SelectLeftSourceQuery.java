package com.shfc.cloud.account.query;

import com.shfc.cloud.account.constant.DeductConstant;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.account.query.SelectLeftSourceQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/24 14:50
 * version V1.0.0
 */
public class SelectLeftSourceQuery implements Serializable {
    private Long merchantId;//商户ID
    private String channelNo;//频道号
    private DeductConstant type;//类型

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

    public DeductConstant getType() {
        return type;
    }

    public void setType(DeductConstant type) {
        this.type = type;
    }
}
