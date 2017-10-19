package com.shfc.cloud.sms.dto;

import com.shfc.mybatis.pagination.Page;
import com.shfc.sms.query.SmsRecordQuery;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.sms.dto.SmsRecordWebQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/30 11:31
 * version V1.0.0
 */
@ApiModel(value = "SmsRecordWebDTO")
public class SmsRecordWebDTO implements Serializable {
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private String mobile;//发送手机号
    private String sendStatus;//发送状态(0-成功 1-失败)
    private String beginTime;//开始时间
    private String endTime;//结束时间
    private Integer pageSize = Integer.valueOf(20);
    private Integer pageNumber = Integer.valueOf(1);

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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
