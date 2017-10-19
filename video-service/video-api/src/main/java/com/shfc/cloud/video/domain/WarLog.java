package com.shfc.cloud.video.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.video.domain.WarLog.java
 * @Description: war包操作记录表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 15:09
 * version v1.0.0
 */
public class WarLog extends BaseBean {
    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 频道编号
     */
    private String channelNo;

    /**
     * war包ID
     */
    private Long warId;

    /**
     * 环境  0:测试环境 1:正式环境
     */
    private Integer environment;

    /**
     * 操作类型 0:下载 1:回滚 2:部署容器 3:重启
     */
    private Integer type;

    /**
     * 是否成功  0:成功 1:失败
     */
    private Integer isSuccess;

    /**
     * 备注
     */
    private String descContent;

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
     * 获取war包ID
     *
     * @return war_id
     */
    public Long getWarId() {
        return warId;
    }

    /**
     * 设置war包ID
     *
     * @param warId
     */
    public void setWarId(Long warId) {
        this.warId = warId;
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
     * 获取操作类型 0:下载 1:回滚 2:部署容器 3:重启
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置操作类型 0:下载 1:回滚 2:部署容器 3:重启
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取是否成功  0:成功 1:失败
     *
     * @return is_success
     */
    public Integer getIsSuccess() {
        return isSuccess;
    }

    /**
     * 设置是否成功  0:成功 1:失败
     *
     * @param isSuccess
     */
    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * 获取备注
     *
     * @return desc
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
}