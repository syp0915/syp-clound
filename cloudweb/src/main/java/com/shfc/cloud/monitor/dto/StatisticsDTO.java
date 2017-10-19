package com.shfc.cloud.monitor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-30 10:51
 **/
@ApiModel(value = "StatisticsDTO")
public class StatisticsDTO implements Serializable {
    private static final long serialVersionUID = -1798415328844823533L;
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道号",required = false)
    private String channelNo;//频道号
    @ApiModelProperty(value = "统计起始时间",required = false)
    private String startTime;//统计起始时间 yyyy-MM-dd HH:mm:ss格式
    @ApiModelProperty(value = "截至时间",required = false)
    private String endTime;//截至时间
    @ApiModelProperty(value = "区县id",required = false)
    private String districtId;//区县id
    @ApiModelProperty(value = "板块id",required = false)
    private String blockId;//板块id
    @ApiModelProperty(value = "小区id",required = false)
    private String residenceId;//小区id
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNumber;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }


    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(String residenceId) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
