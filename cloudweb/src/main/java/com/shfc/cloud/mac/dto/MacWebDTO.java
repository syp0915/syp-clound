package com.shfc.cloud.mac.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.mac.dto.MacWebDTO
 * @Description: mac查询webDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/30 15:10
 * version V1.0.0
 */
@ApiModel(value = "MacWebDTO")
public class MacWebDTO implements Serializable {
    private Long merchantId;//商户id
    private String channelNo;//频道号
    private Long districtId;//区县ID
    private Long blockId;//板块ID
    private Long residenceId;//小区ID
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
