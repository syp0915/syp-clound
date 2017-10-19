package com.shfc.cloud.video.dto;

import com.shfc.cloud.video.constant.AttachStatusConstant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package com.shfc.cloud.video.dto.ResourceListDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:50
 * version V1.0.0
 */
public class ResourceListDTO  implements Serializable {

    private Long fileId;//附件ID
    private String channelNo;//频道号
    private String channelType;//频道类型
    private String fileName;//文件名称
    private String imgUrl;//图片缩率图片URL
    private int imgType;//状态
    private String status;//状态
    private BigDecimal imgSize;//附件大小
    private Date createTime;//上传时间
    private String thumbnailPicture;//缩略图片
    private int statusCode;//状态

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return AttachStatusConstant.getNameByValue(statusCode);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumbnailPicture() {
        return thumbnailPicture;
    }

    public void setThumbnailPicture(String thumbnailPicture) {
        this.thumbnailPicture = thumbnailPicture;
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

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
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

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public BigDecimal getImgSize() {
        return imgSize;
    }

    public void setImgSize(BigDecimal imgSize) {
        this.imgSize = imgSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
