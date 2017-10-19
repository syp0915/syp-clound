package com.shfc.cloud.monitor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.dto
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-28 17:13
 * version V1.0.0
 **/
@ApiModel
public class RealTimeStatisticsDTO {

    @ApiModelProperty(value = "频道号",required = true)
    private String channelNo;

    @ApiModelProperty(value = "统计时间维度",required = true)
    private int period;

    @ApiModelProperty(value = "区县id",required = false)
    private String districtId;

    @ApiModelProperty(value = "板块id",required = false)
    private String blockId;

    @ApiModelProperty(value = "小区id",required = false)
    private String residenceId;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
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
}
