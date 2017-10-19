package com.shfc.cloud.video.query;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Package com.shfc.cloud.video.query.ImgZoomQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:24
 * version V1.0.0
 */
public class ImgZoomQuery implements Serializable {
    private Long merchantId;//商户编号
    private String imageUrl;//图片URL
    private int width;//长度
    private int height;//高度
    private BigDecimal size;//比例(图片和比例缩放可以选其一)
    private String channelNo;//频道号

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }
}
