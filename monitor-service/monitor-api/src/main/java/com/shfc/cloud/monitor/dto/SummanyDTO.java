package com.shfc.cloud.monitor.dto;/**
 * Created by SYP on 2017/3/30.
 */

import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.dto
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 17:11
 * version V1.0.0
 **/
public class SummanyDTO implements Serializable {
    /**
     * 数据列表
     */
    private JSONArray SunmmanyList;

    /**
     * 查询纬度等级
     */
    private Integer queryLevel;

    public JSONArray getSunmmanyList() {
        return SunmmanyList;
    }

    public void setSunmmanyList(JSONArray sunmmanyList) {
        SunmmanyList = sunmmanyList;
    }

    public Integer getQueryLevel() {
        return queryLevel;
    }

    public void setQueryLevel(Integer queryLevel) {
        this.queryLevel = queryLevel;
    }
}
