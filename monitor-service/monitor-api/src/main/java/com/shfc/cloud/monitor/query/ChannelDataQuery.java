package com.shfc.cloud.monitor.query;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 频道列表请求入参
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-27 17:25
 **/
public class ChannelDataQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = -6251839705089533418L;
    private Long merchantId;

    private String channelNo;

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
