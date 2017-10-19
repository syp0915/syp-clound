package com.shfc.flowscreen.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.flowscreen.domain.FlowscreenRecord
 * @Description: FlowscreenRecord
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/29 10:17
 * version v1.0.0
 */
public class FlowscreenRecord extends BaseBean {
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 频道号
     */
    private String channelNo;

    /**
     * 机顶盒mac地址
     */
    private String mac;

    /**
     * 0-成功 1-失败 2-异常
     */
    private Integer status;

    /**
     * 飘屏资源
     */
    private String url;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 获取商户id
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户id
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取频道号
     *
     * @return channel_no
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 设置频道号
     *
     * @param channelNo
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    /**
     * 获取机顶盒mac地址
     *
     * @return mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * 设置机顶盒mac地址
     *
     * @param mac
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     * 获取0-成功 1-失败 2-异常
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0-成功 1-失败 2-异常
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取飘屏资源
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置飘屏资源
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取失败原因
     *
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置失败原因
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}