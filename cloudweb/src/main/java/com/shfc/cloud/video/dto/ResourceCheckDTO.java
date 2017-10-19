package com.shfc.cloud.video.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 15:45
 * version V1.0.0
 */
@ApiModel(value = "ResourceCheckDTO")
public class ResourceCheckDTO {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "审批人", required = true)
    private Long approverId;
    @ApiModelProperty(value = "fastDFS数据iD", required = true)
    private Long fileId;
    @ApiModelProperty(value = "审批状态 1:审核通过  2:审核不通过", required = true)
    private Integer status;
    @ApiModelProperty(value = "当状态审核不通过时，审核理由必填", required = true)
    private String reason;
    @ApiModelProperty(value = "是否立即清除FastDFS附件 0:不清除 1:立即清除", required = true)
    private Integer isclear;
    @ApiModelProperty(value = "0 创建 ,1:初审 ,2:二审 3,三审")
    private Integer attachStatus;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAttachStatus() {
        return attachStatus;
    }

    public void setAttachStatus(Integer attachStatus) {
        this.attachStatus = attachStatus;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getIsclear() {
        return isclear;
    }

    public void setIsclear(Integer isclear) {
        this.isclear = isclear;
    }
}
