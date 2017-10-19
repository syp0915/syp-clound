package com.shfc.cloud.account.query;

import com.shfc.cloud.account.constant.CheckStatusConstant;
import com.shfc.cloud.account.dto.MerchantDTO;
import com.shfc.mybatis.pagination.Page;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.account.query.UserListQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 13:32
 * version V1.0.0
 */
public class UserListQuery implements Serializable {
    private Long merchantId;//商户ID
    private String channelNo;//频道号
    private String account;//帐号
    private String companyName;//公司名称
    private CheckStatusConstant status;//状态
    private int statusCode;
    private Page<MerchantDTO> page = new Page<MerchantDTO>();

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Page<MerchantDTO> getPage() {
        return page;
    }

    public void setPage(Page<MerchantDTO> page) {
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public CheckStatusConstant getStatus() {
        return status;
    }

    public void setStatus(CheckStatusConstant status) {
        this.status = status;
    }
}
