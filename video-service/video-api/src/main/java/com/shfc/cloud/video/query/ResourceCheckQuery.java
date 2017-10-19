package com.shfc.cloud.video.query;

import com.shfc.cloud.video.constant.ApproverTypeConstant;
import com.shfc.cloud.video.constant.CheckConstant;
import com.shfc.cloud.video.constant.ClearConstant;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.query.ResourceCheckQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 15:03
 * version V1.0.0
 */
public class ResourceCheckQuery implements Serializable {
    private Long merchantId;//商户编号
    private String channelNo;//频道号
    private Long approverId;//审批人
    private Long fileId;//审批附件ID
    private String reason;//审批理由	当状态审核不通过时，审核理由必填
    private CheckConstant status;//审批状态
    private ClearConstant isclear;//是否立即清除FastDFS附件
    private ApproverTypeConstant attachStatus;

    public ApproverTypeConstant getAttachStatus() {
        return attachStatus;
    }

    public void setAttachStatus(ApproverTypeConstant attachStatus) {
        this.attachStatus = attachStatus;
    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CheckConstant getStatus() {
        return status;
    }

    public void setStatus(CheckConstant status) {
        this.status = status;
    }

    public ClearConstant getIsclear() {
        return isclear;
    }

    public void setIsclear(ClearConstant isclear) {
        this.isclear = isclear;
    }
}
