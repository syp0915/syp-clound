package com.shfc.cloud.gateway.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:44
 * @since 1.0
 */
@ApiModel(value = "GatewayAuthWebDTO")
public class GatewayAuthWebDTO implements Serializable{
    private static final long serialVersionUID = -1319411026463432756L;
    @ApiModelProperty(value = "商户id", required = true)
    private long merchantId;
    @ApiModelProperty(value = "频道号", required = true)
    private String channelNo;
    @ApiModelProperty(value = "开始时间", required = true)
    private String startTime;
    @ApiModelProperty(value = "截止时间", required = true)
    private String endTime;
    @ApiModelProperty(value = "有效期", required = true)
    private int validity;
    @ApiModelProperty(value = "id", required = false)
    private long id;

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
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

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
