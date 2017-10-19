package com.shfc.cloud.video.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * @Package com.shfc.cloud.resource.dto.ImgZoomDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 15:39
 * version V1.0.0
 */
@ApiModel(value = "ImgZoomDTO")
public class ImgZoomDTO {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "图片路径", required = true)
    private String imageUrl;
    @ApiModelProperty(value = "图片长度", required = false)
    private int width;
    @ApiModelProperty(value = "图片高度", required = false)
    private int height;
    @ApiModelProperty(value = "图片比例", required = false)
    private BigDecimal size;

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

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
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
}
