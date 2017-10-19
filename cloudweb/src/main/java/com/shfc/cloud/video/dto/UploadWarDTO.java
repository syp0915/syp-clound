package com.shfc.cloud.video.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.InputStream;

/**
 * @Package com.shfc.cloud.resource.dto.UploadWarDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 16:10
 * version V1.0.0
 */
@ApiModel(value = "UploadFileDTO")
public class UploadWarDTO {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "war包附件", required = true)
    private InputStream warContent;
    @ApiModelProperty(value = "环境(0:测试环境 1:正式环境)", required = true)
    private int environment ;
    @ApiModelProperty(value = "war包名称", required = true)
    private String warName;
    @ApiModelProperty(value = "版本", required = true)
    private String warVersion;
    @ApiModelProperty(value = "上传人", required = true)
    private Long uploadId;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public InputStream getWarContent() {
        return warContent;
    }

    public void setWarContent(InputStream warContent) {
        this.warContent = warContent;
    }

    public int getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environment) {
        this.environment = environment;
    }

    public String getWarName() {
        return warName;
    }

    public void setWarName(String warName) {
        this.warName = warName;
    }

    public String getWarVersion() {
        return warVersion;
    }

    public void setWarVersion(String warVersion) {
        this.warVersion = warVersion;
    }
}
