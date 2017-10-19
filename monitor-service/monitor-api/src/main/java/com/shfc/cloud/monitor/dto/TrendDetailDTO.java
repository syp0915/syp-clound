package com.shfc.cloud.monitor.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.dto
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 14:21
 * version V1.0.0
 **/
public class TrendDetailDTO extends RealTimeSummaryDTO implements Serializable {

    /**
     * 统计开始时刻
     */
    private Date timeBegin;

    /**
     * 统计结束时间
     */
    private Date timeEnd;

    /**
     * 停留平均时长
     */
    private Long avgTop;

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Long getAvgTop() {
        return avgTop;
    }

    public void setAvgTop(Long avgTop) {
        this.avgTop = avgTop;
    }
}
