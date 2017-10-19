package com.shfc.cloud.monitor.query;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.query
 * @Description: 实时统计请求参数
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-29 9:21
 * version V1.0.0
 **/
public class RealTimeStatisticsQuery implements Serializable {

    /**
     * 频道号
     */
    private String channelNo;
    /**
     * 时间维度统计
     */
    private Integer period;

    /**
     * 区县id
     */
    private String districtId;

    /**
     * 板块id
     */
    private String blockId;

    /**
     * 小区id
     */
    private String residenceId;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
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
