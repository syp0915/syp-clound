package com.shfc.cloud.monitor.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-27 17:17
 **/
public class ChannelDataDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -7020474046103454816L;

    private List<VisitDataDTO> dataList;

    public List<VisitDataDTO> getDataList() {
        return dataList;
    }

    public void setDataList(List<VisitDataDTO> dataList) {
        this.dataList = dataList;
    }
}
