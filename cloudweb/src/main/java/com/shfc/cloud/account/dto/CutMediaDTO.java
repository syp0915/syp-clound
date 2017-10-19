package com.shfc.cloud.account.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.account.dto.CutMediaDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 14:28
 * version V1.0.0
 */
@ApiModel(value = "CutMediaDTO")
public class CutMediaDTO {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "类型(image,video)", required = true)
    private String type;
    @ApiModelProperty(value = "大小(单位KB)", required = true)
    private Long size;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
