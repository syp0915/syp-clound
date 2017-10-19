package com.shfc.cloud.video.query;

import com.shfc.cloud.video.dto.WarlistDTO;
import com.shfc.mybatis.pagination.Page;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.query.WarlistQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:15
 * version V1.0.0
 */
public class WarlistQuery implements Serializable {
    private Long merchantId;//商户编号
    private String channelNo;//频道号
    private String environment;//环境
    private Page<WarlistDTO> page = new Page<WarlistDTO>();

    public Page<WarlistDTO> getPage() {
        return page;
    }

    public void setPage(Page<WarlistDTO> page) {
        this.page = page;
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

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
