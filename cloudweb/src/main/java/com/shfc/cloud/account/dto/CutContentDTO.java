package com.shfc.cloud.account.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.account.dto.CutContentDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 14:21
 * version V1.0.0
 */
@ApiModel(value = "CutContentDTO")
public class CutContentDTO {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "条目", required = true)
    private Long number;
    @ApiModelProperty(value = "类型(0:短信 1:语音验证码 2:认证余额)", required = true)
    private int type;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
