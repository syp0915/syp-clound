package com.shfc.cloud.monitor.query;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 收视历史
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-29 09:27
 **/
public class VisitHistoryQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 4448395344661637055L;
    private Long merchantId;//商户Id

    private String channelNo;//频道号
    private Date startTime;//统计起始时间 yyyy-MM-dd HH:mm:ss格式
    private Date endTime;//统计时间纬度
    private String districtId;//区县id
    private String blockId;//板块id
    private String residenceId;//小区id

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(String residenceId) {
        this.residenceId = residenceId;
    }
}
