package com.shfc.cloud.account.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.account.dto.DeductDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/24 11:00
 * version V1.0.0
 */
public class DeductDTO implements Serializable {
    private Long merchantId;//商户ID
    private String channelNo;//频道号
    private Long type;//类型

    public DeductDTO(Long merchantId,String channelNo,Long type){
        this.merchantId = merchantId;
        this.channelNo = channelNo;
        this.type = type;
    }

    public DeductDTO(){

    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
