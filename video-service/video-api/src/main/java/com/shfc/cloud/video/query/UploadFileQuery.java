package com.shfc.cloud.video.query;

import com.shfc.cloud.video.constant.AttachConstant;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.query.UploadFileQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 15:36
 * version V1.0.0
 */
public class UploadFileQuery implements Serializable {
    private Long merchantId;//商户编号
    private String channelNo;//频道编号
    private AttachConstant type;//附件类型
    private String fileName;//附件名称
    private Long kiloByte;//文件大小
    private String url;//路径
    private String urlImage;//缩略图片

    public Long getKiloByte() {
        return kiloByte;
    }

    public void setKiloByte(Long kiloByte) {
        this.kiloByte = kiloByte;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public AttachConstant getType() {
        return type;
    }

    public void setType(AttachConstant type) {
        this.type = type;
    }
}
