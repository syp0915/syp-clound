package com.shfc.sms.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.sms.dto.SmsBatchResultDTO
 * @Description: 接收批量发送结果的DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/29 17:46
 * version V1.0.0
 */
public class SmsBatchResultDTO implements Serializable{
    private Integer totalCount;//总条目
    private List<SmsResultDTO> dataList  = new ArrayList<>();//批量短信明细

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<SmsResultDTO> getDataList() {
        return dataList;
    }

    public void setDataList(List<SmsResultDTO> dataList) {
        this.dataList = dataList;
    }
}
