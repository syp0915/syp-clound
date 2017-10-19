package com.shfc.cloud.video.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.resource.dto.VideoTranscodDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 15:42
 * version V1.0.0
 */
@ApiModel(value = "VideoTranscodDTO")
public class VideoTranscodDTO {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "原视频fastDFS数据iD", required = true)
    private String fileId;
    @ApiModelProperty(value = "原视频fastDFS数据URL", required = true)
    private String fileUrl;

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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
