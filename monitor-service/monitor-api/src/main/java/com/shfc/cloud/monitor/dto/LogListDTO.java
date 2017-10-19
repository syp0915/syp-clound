package com.shfc.cloud.monitor.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 日志列表
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-28 14:52
 **/
public class LogListDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = -1504793865991047994L;

    private List<LogDTO> dataList;

    public List<LogDTO> getDataList() {
        return dataList;
    }

    public void setDataList(List<LogDTO> dataList) {
        this.dataList = dataList;
    }
}
