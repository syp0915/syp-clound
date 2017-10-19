package com.shfc.cloud.account.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.cloud.account.dto.UserListDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/21 14:38
 * version V1.0.0
 */
@ApiModel(value = "UserListDTO")
public class UserListDTO {
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "频道编号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "帐号", required = false)
    private String account;
    @ApiModelProperty(value = "公司名称", required = false)
    private String companyName;
    @ApiModelProperty(value = "审核状态(0:全部 1:已审核 2:未审核 3未通过)", required = false)
    private int status;
    @ApiModelProperty(value = "每页条数", required = true)
    private int pageSize;
    @ApiModelProperty(value = "当前页码", required = true)
    private int pageNumber;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
