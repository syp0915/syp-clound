package com.shfc.cloud.monitor.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.dto
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 16:23
 * version V1.0.0
 **/
public class SummanyDetailDTO extends RealTimeSummaryDTO implements Serializable {
    /**
     * 子节点Id
     *queryLevel=0时pointId=districtId
     *queryLevel=1时pointId=blockId
     *queryLevel=2时parentId=residenceId
     */
    private String pointId;
    /**
     * 子节点名称
     * queryLevel=0时pointId=districtName
     * queryLevel=1时pointId=blockName
     * queryLevel=2时parentId=residenceName
     */
    private String pointName;


    /**
     * 目标点纬度
     */
    private Double latitude;

    /**
     *目标点经度
     */
    private Double longitude;

    /**
     * 停留平均时长
     */
    private Long avgTop;

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getAvgTop() {
        return avgTop;
    }

    public void setAvgTop(Long avgTop) {
        this.avgTop = avgTop;
    }
}
