package com.shfc.cloud.cloudbase.dto;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/4/5 下午2:17.
 */
public class ChannelMerchantDTO implements Serializable {
    private String channelNo;//频道号
    private Long merchantId;//商户id

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
