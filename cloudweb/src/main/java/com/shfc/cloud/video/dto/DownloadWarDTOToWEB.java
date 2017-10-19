package com.shfc.cloud.video.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.resource.dto.DownloadWarDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 16:15
 * version V1.0.0
 */
@ApiModel(value = "DownloadWarDTOToWEB")
public class DownloadWarDTOToWEB {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "war包ID", required = true)
    private Long warId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;

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

    public Long getWarId() {
        return warId;
    }

    public void setWarId(Long warId) {
        this.warId = warId;
    }
}
