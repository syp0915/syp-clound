package com.shfc.cloud.video.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.video.domain.Attach.java
 * @Description: 附件表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 13:41
 * version v1.0.0
 */
public class Attach extends BaseBean {
    /**
     * 附件名称
     */
    private String attachName;

    /**
     * 附件URL路径
     */
    private String attachUrl;

    /**
     * 电视云URL路径
     */
    private String tvUrl;

    /**
     * 附件后缀类型
     */
    private String attachSuffix;

    /**
     * FastDFS附件名称
     */
    private String fastdfsName;

    /**
     * 附件大小 单位:KB
     */
    private Long attachSize;

    /**
     * 0:未清除 1:已被清除
     */
    private Integer isDel;

    /**
     * 缩略图片
     */
    private String thumbnailPicture;

    /**
     * 获取附件名称
     *
     * @return attach_name
     */
    public String getAttachName() {
        return attachName;
    }

    /**
     * 设置附件名称
     *
     * @param attachName
     */
    public void setAttachName(String attachName) {
        this.attachName = attachName == null ? null : attachName.trim();
    }

    /**
     * 获取附件URL路径
     *
     * @return attach_url
     */
    public String getAttachUrl() {
        return attachUrl;
    }

    /**
     * 设置附件URL路径
     *
     * @param attachUrl
     */
    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl == null ? null : attachUrl.trim();
    }

    /**
     * 获取电视云URL路径
     *
     * @return tv_url
     */
    public String getTvUrl() {
        return tvUrl;
    }

    /**
     * 设置电视云URL路径
     *
     * @param tvUrl
     */
    public void setTvUrl(String tvUrl) {
        this.tvUrl = tvUrl == null ? null : tvUrl.trim();
    }

    /**
     * 获取附件后缀类型
     *
     * @return attach_suffix
     */
    public String getAttachSuffix() {
        return attachSuffix;
    }

    /**
     * 设置附件后缀类型
     *
     * @param attachSuffix
     */
    public void setAttachSuffix(String attachSuffix) {
        this.attachSuffix = attachSuffix == null ? null : attachSuffix.trim();
    }

    /**
     * 获取FastDFS附件名称
     *
     * @return fastdfs_name
     */
    public String getFastdfsName() {
        return fastdfsName;
    }

    /**
     * 设置FastDFS附件名称
     *
     * @param fastdfsName
     */
    public void setFastdfsName(String fastdfsName) {
        this.fastdfsName = fastdfsName == null ? null : fastdfsName.trim();
    }

    /**
     * 获取附件大小 单位:KB
     *
     * @return attach_size
     */
    public Long getAttachSize() {
        return attachSize;
    }

    /**
     * 设置附件大小 单位:KB
     *
     * @param attachSize
     */
    public void setAttachSize(Long attachSize) {
        this.attachSize = attachSize;
    }

    /**
     * 获取0:未清除 1:已被清除
     *
     * @return is_del
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 设置0:未清除 1:已被清除
     *
     * @param isDel
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取缩略图片
     *
     * @return thumbnail_picture
     */
    public String getThumbnailPicture() {
        return thumbnailPicture;
    }

    /**
     * 设置缩略图片
     *
     * @param thumbnailPicture
     */
    public void setThumbnailPicture(String thumbnailPicture) {
        this.thumbnailPicture = thumbnailPicture == null ? null : thumbnailPicture.trim();
    }
}