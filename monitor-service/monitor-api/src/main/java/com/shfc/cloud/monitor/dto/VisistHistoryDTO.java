package com.shfc.cloud.monitor.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-29 09:29
 **/
public class VisistHistoryDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 1149933347732882648L;

    private List<HistoryDTO> dataList;

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }
}
