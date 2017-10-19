package com.shfc.cloud.monitor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.dto
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-28 17:28
 * version V1.0.0
 **/
@ApiModel
public class TimeTrendDTO {

    @ApiModelProperty(value = "频道号",required = true)
    private String channelNo;

    @ApiModelProperty(value = "统计起始时间",required = true)
    private Long startTime;                   //yyyy-MM-dd HH:mm:ss格式

    @ApiModelProperty(value = "对比起始时间",required = true)
    private Long contrastiveStartTime;       //yyyy-MM-dd HH:mm:ss格式

    @ApiModelProperty(value = "统计时间纬度",required = true)
    private Long span;

    @ApiModelProperty(value = "时间刻度",required = true)
    private Long scale;

    @ApiModelProperty(value = "区县id",required = true)
    private String districtId;

    @ApiModelProperty(value = "板块id",required = true)
    private String blockId;

    @ApiModelProperty(value = "小区id",required = true)
    private String residenceId;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getContrastiveStartTime() {
        return contrastiveStartTime;
    }

    public void setContrastiveStartTime(Long contrastiveStartTime) {
        this.contrastiveStartTime = contrastiveStartTime;
    }

    public Long getSpan() {
        return span;
    }

    public void setSpan(Long span) {
        this.span = span;
    }

    public Long getScale() {
        return scale;
    }

    public void setScale(Long scale) {
        this.scale = scale;
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
