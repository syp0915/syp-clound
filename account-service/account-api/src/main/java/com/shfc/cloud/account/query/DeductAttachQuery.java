package com.shfc.cloud.account.query;

import com.shfc.cloud.account.constant.AttachConstant;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.account.query.DeductAttachQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 13:22
 * version V1.0.0
 */
public class DeductAttachQuery implements Serializable {
    private Long merchantId;//商户ID
    private String channelNo;//频道号
    private Long size;//大小(单位KB)
    private AttachConstant type;//类型 图片和视频

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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public AttachConstant getType() {
        return type;
    }

    public void setType(AttachConstant type) {
        this.type = type;
    }
}
