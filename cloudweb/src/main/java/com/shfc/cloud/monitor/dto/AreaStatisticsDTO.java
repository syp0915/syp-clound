package com.shfc.cloud.monitor.dto;/**
 * Created by SYP on 2017/3/28.
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author sunyaping
 * @Package com.shfc.cloud.monitor.dto
 * @Description TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-03-28 17:19
 * version V1.0.0
 **/
@ApiModel
public class AreaStatisticsDTO {

    @ApiModelProperty(value = "频道号",required = true)
    private String channelNo;

    @ApiModelProperty(value = "统计起始时间",required = true)
    private Long startTime;        //yyyy-MM-dd HH:mm:ss格式

    @ApiModelProperty(value = "统计时间纬度",required = true)
    private Long span;

    @ApiModelProperty(value = "父级id",required = true)
    private String parentId;

    @ApiModelProperty(value = "地区查询维度等级",required = true)
    private Integer queryLevel;       //0-城市级 1-区县级 1-板块级别

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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getSpan() {
        return span;
    }

    public void setSpan(Long span) {
        this.span = span;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getQueryLevel() {
        return queryLevel;
    }

    public void setQueryLevel(Integer queryLevel) {
        this.queryLevel = queryLevel;
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
