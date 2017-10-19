package com.shfc.cloud.video.query;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.query.DownloadWarQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:05
 * version V1.0.0
 */
public class DownloadWarQuery implements Serializable {
    private Long merchantId;//商户编号
    private Long warId;//war包ID
    private String channelNo;//频道号
    private Integer pageSize;
    private Integer pageNumber;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getWarId() {
        return warId;
    }

    public void setWarId(Long warId) {
        this.warId = warId;
    }
}
