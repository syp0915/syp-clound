package com.shfc.cloud.monitor.dto;



import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.dto
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-30 14:43
 * version V1.0.0
 **/
public class TrendDTO implements Serializable {

    private JSONArray cureentTrendList;
    private JSONArray contrastiveTrendList;

    public JSONArray getCureentTrendList() {
        return cureentTrendList;
    }

    public void setCureentTrendList(JSONArray cureentTrendList) {
        this.cureentTrendList = cureentTrendList;
    }

    public JSONArray getContrastiveTrendList() {
        return contrastiveTrendList;
    }

    public void setContrastiveTrendList(JSONArray contrastiveTrendList) {
        this.contrastiveTrendList = contrastiveTrendList;
    }
}
