package com.shfc.sms.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.sms.domain.SmsLog.java
 * @Description: 短信通道调用日志
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2017 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/01 14:18
 * version v1.0.0
 */
public class SmsLog extends BaseBean {
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 频道号
     */
    private String channelNo;

    /**
     * 短信通道(0-云片)
     */
    private Integer channel;

    /**
     * 请求类型(0-签名操作 1-模板操作 2-单条发送3-批量发送相同内容 4-批量发送不同内容
             5-语音发送 6-指定模板单发7-指定模板群发8-查询短信发送记录 9-查询屏蔽词)
     */
    private Integer reqType;

    /**
     * 请求链接
     */
    private String reqUrl;

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
     * 获取短信通道(0-云片)
     *
     * @return channel
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * 设置短信通道(0-云片)
     *
     * @param channel
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * 获取请求类型(0-签名操作 1-模板操作 2-单条发送3-批量发送相同内容 4-批量发送不同内容
             5-语音发送 6-指定模板单发7-指定模板群发8-查询短信发送记录 9-查询屏蔽词)
     *
     * @return req_type
     */
    public Integer getReqType() {
        return reqType;
    }

    /**
     * 设置请求类型(0-签名操作 1-模板操作 2-单条发送3-批量发送相同内容 4-批量发送不同内容
             5-语音发送 6-指定模板单发7-指定模板群发8-查询短信发送记录 9-查询屏蔽词)
     *
     * @param reqType
     */
    public void setReqType(Integer reqType) {
        this.reqType = reqType;
    }

    /**
     * 获取请求链接
     *
     * @return req_url
     */
    public String getReqUrl() {
        return reqUrl;
    }

    /**
     * 设置请求链接
     *
     * @param reqUrl
     */
    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl == null ? null : reqUrl.trim();
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

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/03/01 14:18
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
        sb.append(", channel=").append(channel);
        sb.append(", reqType=").append(reqType);
        sb.append(", reqUrl=").append(reqUrl);
        sb.append(", status=").append(status);
        sb.append(", reqContent=").append(reqContent);
        sb.append(", respContent=").append(respContent);
        sb.append("]");
        return sb.toString();
    }
}