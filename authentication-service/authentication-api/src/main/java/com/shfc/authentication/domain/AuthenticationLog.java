package com.shfc.authentication.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.authentication.domain.AuthenticationLog.java
 * @Description: 实名认证通道调用日志
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016
 * All right reserved.
 * Author xiehb
 * @date 2017/03/17 09:50
 * version v1.0.0
 */
public class AuthenticationLog extends BaseBean {
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 频道号
     */
    private String channelNo;

    /**
     * 实名认证通道(0-京东万象)
     */
    private Integer channel;

    /**
     * 0-成功 1-失败 2-异常
     */
    private Integer status;

    /**
     * 请求内容
     */
    private String reqContent;

    /**
     * 响应内容
     */
    private String respContent;

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
        this.channelNo = channelNo;
    }

    /**
     * 获取实名认证通道(0-京东万象)
     *
     * @return channel
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * 设置实名认证通道(0-京东万象)
     *
     * @param channel
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
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
     * 获取请求内容
     *
     * @return req_content
     */
    public String getReqContent() {
        return reqContent;
    }

    /**
     * 设置请求内容
     *
     * @param reqContent
     */
    public void setReqContent(String reqContent) {
        this.reqContent = reqContent == null ? null : reqContent.trim();
    }

    /**
     * 获取响应内容
     *
     * @return resp_content
     */
    public String getRespContent() {
        return respContent;
    }

    /**
     * 设置响应内容
     *
     * @param respContent
     */
    public void setRespContent(String respContent) {
        this.respContent = respContent == null ? null : respContent.trim();
    }

    /**
     * @Title toString
     * @Author xiehb
     * @Date 2017/03/17 09:50
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantId=").append(merchantId);
        sb.append(", channelNo=").append(channelNo);
        sb.append(", channel=").append(channel);
        sb.append(", status=").append(status);
        sb.append(", reqContent=").append(reqContent);
        sb.append(", respContent=").append(respContent);
        sb.append("]");
        return sb.toString();
    }
}