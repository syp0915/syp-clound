package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 日志详情
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-28 14:46
 **/
public class LogDTO implements Serializable{
    private static final long serialVersionUID = -2831611814419049541L;
    private String mac;//机顶盒mac地址
    private String channelNo;
    private String region;//区域板块
    private String residenceName;//小区
    private String time;//访问时间

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }
}
