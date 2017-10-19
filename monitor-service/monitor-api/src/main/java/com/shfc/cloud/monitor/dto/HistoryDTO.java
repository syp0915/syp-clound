package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-29 09:30
 **/
public class HistoryDTO implements Serializable{

    private static final long serialVersionUID = 405179526829128221L;
    private String mac;//机顶盒mac地址

    private String channelNo;//频道号

    private long pv;//访问量

    private String firstVisitTime;//首次访问时间

    private String lastVisitTime;//最后访问时间
    private long viewLength;//收看时长

    private long avgTop;//平均停留时长


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public long getPv() {
        return pv;
    }

    public void setPv(long pv) {
        this.pv = pv;
    }

    public String getFirstVisitTime() {
        return firstVisitTime;
    }

    public void setFirstVisitTime(String firstVisitTime) {
        this.firstVisitTime = firstVisitTime;
    }

    public String getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(String lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public long getViewLength() {
        return viewLength;
    }

    public void setViewLength(long viewLength) {
        this.viewLength = viewLength;
    }

    public long getAvgTop() {
        return avgTop;
    }

    public void setAvgTop(long avgTop) {
        this.avgTop = avgTop;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }
}
