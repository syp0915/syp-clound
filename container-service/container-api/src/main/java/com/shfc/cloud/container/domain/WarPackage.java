package com.shfc.cloud.container.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.container.domain.WarPackage.java
 * @Description: war包表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/05/09 14:26
 * version v1.0.0
 */
public class WarPackage extends BaseBean {
    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 频道编号
     */
    private String channelNo;

    /**
     * war包名称
     */
    private String warName;

    /**
     * 环境  0:测试环境 1:正式环境
     */
    private Integer environment;

    /**
     * war包大小(单位(KB))
     */
    private Long warSize;

    /**
     * war版本
     */
    private String warVersion;

    /**
     * war路径
     */
    private String warUrl;

    /**
     * war包真实附件名称
     */
    private String warRealname;

    /**
     * 备注
     */
    private String descContent;

    /**
     * 使用状态
     */
    private Integer status;

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
     * 获取war包名称
     *
     * @return war_name
     */
    public String getWarName() {
        return warName;
    }

    /**
     * 设置war包名称
     *
     * @param warName
     */
    public void setWarName(String warName) {
        this.warName = warName == null ? null : warName.trim();
    }

    /**
     * 获取环境  0:测试环境 1:正式环境
     *
     * @return environment
     */
    public Integer getEnvironment() {
        return environment;
    }

    /**
     * 设置环境  0:测试环境 1:正式环境
     *
     * @param environment
     */
    public void setEnvironment(Integer environment) {
        this.environment = environment;
    }

    /**
     * 获取war包大小(单位(KB))
     *
     * @return war_size
     */
    public Long getWarSize() {
        return warSize;
    }

    /**
     * 设置war包大小(单位(KB))
     *
     * @param warSize
     */
    public void setWarSize(Long warSize) {
        this.warSize = warSize;
    }

    /**
     * 获取war版本
     *
     * @return war_version
     */
    public String getWarVersion() {
        return warVersion;
    }

    /**
     * 设置war版本
     *
     * @param warVersion
     */
    public void setWarVersion(String warVersion) {
        this.warVersion = warVersion == null ? null : warVersion.trim();
    }

    /**
     * 获取war路径
     *
     * @return war_url
     */
    public String getWarUrl() {
        return warUrl;
    }

    /**
     * 设置war路径
     *
     * @param warUrl
     */
    public void setWarUrl(String warUrl) {
        this.warUrl = warUrl == null ? null : warUrl.trim();
    }

    /**
     * 获取war包真实附件名称
     *
     * @return war_realname
     */
    public String getWarRealname() {
        return warRealname;
    }

    /**
     * 设置war包真实附件名称
     *
     * @param warRealname
     */
    public void setWarRealname(String warRealname) {
        this.warRealname = warRealname == null ? null : warRealname.trim();
    }

    /**
     * 获取备注
     *
     * @return desc_content
     */
    public String getDescContent() {
        return descContent;
    }

    /**
     * 设置备注
     *
     * @param descContent
     */
    public void setDescContent(String descContent) {
        this.descContent = descContent == null ? null : descContent.trim();
    }

    /**
     * 获取使用状态
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置使用状态
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}