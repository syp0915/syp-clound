package com.shfc.cloud.monitor.query;

import javax.ws.rs.DefaultValue;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.query
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 16:14
 * version V1.0.0
 **/
public class SummaryQuery extends  BaseQuery implements Serializable {

    /**
     * 频道号
     */
    private String channelNo;

    /**
     * 统计开始时间
     */
    private Long startTime;

    /**
     * 统计时间维度
     */
    private Long span;

    /**
     * 区县id
     */
    private Integer districtId;

    /**
     * 板块id
     */
    private Integer blockId;


    private Integer queryLevel;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getSpan() {
        return span;
    }

    public void setSpan(Long span) {
        this.span = span;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }


    public Integer getQueryLevel() {
        return queryLevel;
    }

    public void setQueryLevel(Integer queryLevel) {
        this.queryLevel = queryLevel;
    }
}
