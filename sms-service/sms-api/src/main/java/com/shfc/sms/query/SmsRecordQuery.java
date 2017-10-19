package com.shfc.sms.query;

import com.shfc.mybatis.pagination.Page;

import java.io.Serializable;

/**
 * @Package com.shfc.sms.query.SmsRecordQuery
 * @Description: 消息记录查询
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/7 15:20
 * version V1.0.0
 */
public class SmsRecordQuery implements Serializable{
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private Long templateId;//商户短信模板id
    private String mobile;//发送手机号
    private String sendStatus;//发送状态(0-成功 1-失败)
    private String beginTime;//开始时间
    private String endTime;//结束时间
    private String batchType;
    private Page<SmsRecordQuery> page = new Page<>();

    public Page<SmsRecordQuery> getPage() {
        return page;
    }

    public void setPage(Page<SmsRecordQuery> page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return page.getPageSize();
    }

    public void setPageSize(Integer pageSize) {
        page.setPageSize(pageSize);
    }

    public Integer getPageNumber() {
        return page.getPageNumber();
    }

    public void setPageNumber(Integer pageNumber) {
        page.setPageNumber(pageNumber);
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBatchType() {
        return batchType;
    }

    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }
}
