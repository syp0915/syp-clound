package com.shfc.cloud.video.dto;

import com.shfc.cloud.video.constant.AttachConstant;
import com.shfc.cloud.video.constant.AttachStatusConstant;
import com.shfc.cloud.video.constant.ChannelTypeConstant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.cloud.video.dto.ResourceInfoDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 15:22
 * version V1.0.0
 */
public class ResourceInfoDTO  implements Serializable {
    private Long fileId;//附件ID
    private String channelNo;//频道号
    private String channelName;//频道名称
    private int channelType;//频道类型
    private String channelTypeName;//频道类型
    private String fileName;//文件名称
    private String imgUrl;//图片URL
    private int imgType;//格式
    private String imgTypeName;//格式
    private BigDecimal imgSize;//大小
    private Date approverTime;//审核时间
    private Date createTime;//上传时间
    private int status;//状态
    private String statusName;//状态
    private String desc;//备注
    private String size;//尺寸
    private List<ApproverDTO> approverList;//审核记录

    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

    public String getChannelTypeName() {
        return ChannelTypeConstant.getNameByValue(channelType);
    }

    public void setChannelTypeName(String channelTypeName) {
        this.channelTypeName = channelTypeName;
    }

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public String getImgTypeName() {
        return AttachConstant.getNameByValue(imgType);
    }

    public void setImgTypeName(String imgTypeName) {
        this.imgTypeName = AttachConstant.getNameByValue(imgType);
    }

    public String getStatusName() {
        return AttachStatusConstant.getNameByValue(status);
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public BigDecimal getImgSize() {
        return imgSize;
    }

    public void setImgSize(BigDecimal imgSize) {
        this.imgSize = imgSize;
    }

    public Date getApproverTime() {
        return approverTime;
    }

    public void setApproverTime(Date approverTime) {
        this.approverTime = approverTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<ApproverDTO> getApproverList() {
        return approverList;
    }

    public void setApproverList(List<ApproverDTO> approverList) {
        this.approverList = approverList;
    }
}
