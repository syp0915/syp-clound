package com.shfc.cloud.video.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Package com.shfc.cloud.resource.dto.ResourceListToWebDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 15:02
 * version V1.0.0
 */
@ApiModel(value = "ResourceListToWebDTO")
public class ResourceListToWebDTO {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "类型(0:图片 1:视频)", required = true)
    private int type;
    @ApiModelProperty(value = "上传开始时间", required = false)
    private Date startDate;
    @ApiModelProperty(value = "上传结束时间", required = false)
    private Date endDate;
    @ApiModelProperty(value = "状态(0:全部 1:待审核 2:通过 3:未通过)", required = false)
    private Integer status;
    @ApiModelProperty(value = "每页条数", required = true)
    private Integer pageSize;
    @ApiModelProperty(value = "当前页码", required = true)
    private Integer pageNumber;

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

    public int getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
