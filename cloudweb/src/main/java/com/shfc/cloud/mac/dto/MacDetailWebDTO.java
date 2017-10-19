package com.shfc.cloud.mac.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.mac.dto.MacDetailWebDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/1 13:55
 * version V1.0.0
 */
@ApiModel(value = "MacDetailWebDTO")
public class MacDetailWebDTO implements Serializable{
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;//商户id
    @ApiModelProperty(value = "频道号", required = true)
    private String channelNo;//频道号
    private String mac;//mac地址

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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
