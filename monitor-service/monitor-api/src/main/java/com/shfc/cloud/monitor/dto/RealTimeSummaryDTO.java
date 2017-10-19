package com.shfc.cloud.monitor.dto;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.dto
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-29 9:12
 * version V1.0.0
 **/
public class RealTimeSummaryDTO implements Serializable {

    /**
     *独立访客
     */
    private Integer uv;

    /**
     *访问量
     */
    private Integer pv;

    /**
     * 新用户数
     */
    private Integer nv;

    /**
     * 刷新时间
     */
    private Long refreshTime;

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getNv() {
        return nv;
    }

    public void setNv(Integer nv) {
        this.nv = nv;
    }

    public Long getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(Long refreshTime) {
        this.refreshTime = refreshTime;
    }
}
