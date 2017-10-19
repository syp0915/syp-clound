package com.shfc.cloud.video.dto;

import com.shfc.cloud.video.constant.ApproverTypeConstant;
import com.shfc.cloud.video.constant.CheckConstant;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.dto.ApproverDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 15:26
 * version V1.0.0
 */
public class ApproverDTO  implements Serializable {
    private Long id;//审核记录ID
    private Long approverId;//审核人
    private String reason;//审批理由或备注
    private String result;//
    private int status;//
    private String statusName;//
    private int approverType;//
    private String approverTypeName;//name
    private String creattime;//创建时间



    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public void setApproverType(int approverType) {
        this.approverType = approverType;
    }

    public String getApproverTypeName() {
        return ApproverTypeConstant.getNameByValue(approverType);
    }

    public void setApproverTypeName(String approverTypeName) {
        this.approverTypeName = approverTypeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusName() {
        return CheckConstant.getNameByValue(status);
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}