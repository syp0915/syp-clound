package com.shfc.cloud.video.query;

import com.shfc.cloud.video.constant.EnvironmentConstant;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.query.UploadWarQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 13:49
 * version V1.0.0
 */
public class UploadWarQuery implements Serializable {
    private Long merchantId;//商户编号
    private String channelNo;//频道号
    private Long uploadId;//上传人
    private EnvironmentConstant environment;//环境
    private String filePath;//路径
    private String warName;//war包名称
    private String warVersion;//war版本
    private String warRealname;//真实名称
    private Long kiloByte;//真实大小 单位Byte

    public Long getKiloByte() {
        return kiloByte;
    }

    public void setKiloByte(Long kiloByte) {
        this.kiloByte = kiloByte;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getWarRealname() {
        return warRealname;
    }

    public void setWarRealname(String warRealname) {
        this.warRealname = warRealname;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getWarVersion() {
        return warVersion;
    }

    public void setWarVersion(String warVersion) {
        this.warVersion = warVersion;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public EnvironmentConstant getEnvironment() {
        return environment;
    }

    public void setEnvironment(EnvironmentConstant environment) {
        this.environment = environment;
    }


    public String getWarName() {
        return warName;
    }

    public void setWarName(String warName) {
        this.warName = warName;
    }
}
