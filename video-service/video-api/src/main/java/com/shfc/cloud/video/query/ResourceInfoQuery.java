package com.shfc.cloud.video.query;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.query.ResourceInfoQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/23 16:30
 * version V1.0.0
 */
public class ResourceInfoQuery implements Serializable {
    private Long merchantId;//商户编号
    private String channelNo;//频道号
    private Long fileId;//附件ID

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

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
