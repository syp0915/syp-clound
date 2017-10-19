package com.shfc.cloud.video.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.video.domain.AttachReviewLog.java
 * @Description: 附件审核记录表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 15:09
 * version v1.0.0
 */
public class AttachReviewLog extends BaseBean {
    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 频道编号
     */
    private String channelNo;

    /**
     * 附件ID
     */
    private Long attachId;

    /**
     * 0:未审核 1:审核通过  2:审核不通过
     */
    private Integer status;

    /**
     * 审核类别 0:创建  1：初审2：二审 3:三审
     */
    private Integer approverType;

    /**
     * 审批理由
     */
    private String reason;

    /**
     * 审批人
     */
    private Long approverId;

    /**
     * 是否立即清除FastDFS附件  0:不清除 1:立即清除
     */
    private Integer isclear;

    /**
     * 获取商户ID
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户ID
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取频道编号
     *
     * @return channel_no
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 设置频道编号
     *
     * @param channelNo
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    /**
     * 获取附件ID
     *
     * @return attach_id
     */
    public Long getAttachId() {
        return attachId;
    }

    /**
     * 设置附件ID
     *
     * @param attachId
     */
    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    /**
     * 获取0:未审核 1:审核通过  2:审核不通过
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:未审核 1:审核通过  2:审核不通过
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取审核类别 0:创建  1：初审2：二审 3:三审
     *
     * @return approver_type
     */
    public Integer getApproverType() {
        return approverType;
    }

    /**
     * 设置审核类别 0:创建  1：初审2：二审 3:三审
     *
     * @param approverType
     */
    public void setApproverType(Integer approverType) {
        this.approverType = approverType;
    }

    /**
     * 获取审批理由
     *
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置审批理由
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 获取审批人
     *
     * @return approver_id
     */
    public Long getApproverId() {
        return approverId;
    }

    /**
     * 设置审批人
     *
     * @param approverId
     */
    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

    /**
     * 获取是否立即清除FastDFS附件  0:不清除 1:立即清除
     *
     * @return isclear
     */
    public Integer getIsclear() {
        return isclear;
    }

    /**
     * 设置是否立即清除FastDFS附件  0:不清除 1:立即清除
     *
     * @param isclear
     */
    public void setIsclear(Integer isclear) {
        this.isclear = isclear;
    }
}