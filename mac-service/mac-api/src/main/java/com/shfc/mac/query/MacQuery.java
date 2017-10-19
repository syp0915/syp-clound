package com.shfc.mac.query;

import java.io.Serializable;

/**
 * @Package com.shfc.mac.query.MacQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/28 15:51
 * version V1.0.0
 */
public class MacQuery implements Serializable {
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private Long districtId;//区县ID
    private Long blockId;//板块ID
    private Long residenceId;//小区ID
    private String mac;//mac地址
    private Integer pageSize = Integer.valueOf(20);
    private Integer pageNumber = Integer.valueOf(1);

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

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
