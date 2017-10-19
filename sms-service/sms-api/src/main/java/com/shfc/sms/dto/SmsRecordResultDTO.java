package com.shfc.sms.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.sms.dto.SmsRecordResultDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/27 15:41
 * version V1.0.0
 */
public class SmsRecordResultDTO implements Serializable {
    private Long sid;//短信主键id
    private String channelNo;//频道号
    private String mobile;//手机号
    private String content;//发送内容
    private Integer sendCount;//发送成功短信的计费条数
    private Integer sendStatus;//发送状态(0-成功 1-失败)
    private Integer batchType;//0批量发送相同内容，1批量发送不同内容

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getBatchType() {
        return batchType;
    }

    public void setBatchType(Integer batchType) {
        this.batchType = batchType;
    }

    @Override
    public String toString() {
        return "SmsRecordResultDTO{" +
                "sid=" + sid +
                ", channelNo='" + channelNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", content='" + content + '\'' +
                ", sendCount=" + sendCount +
                ", sendStatus=" + sendStatus +
                '}';
    }
}
