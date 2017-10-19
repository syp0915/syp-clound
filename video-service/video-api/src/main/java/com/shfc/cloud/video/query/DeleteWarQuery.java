package com.shfc.cloud.video.query;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.query.DeleteWarQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/5/16 17:19
 * version V1.0.0
 */
public class DeleteWarQuery implements Serializable {
    private Long merchantId;//商户编号
    private Long warId;//war包ID
    private String channelNo;//频道号

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getWarId() {
        return warId;
    }

    public void setWarId(Long warId) {
        this.warId = warId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }
}
