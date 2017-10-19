package com.shfc.cloud.gateway.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:32
 * @since 1.0
 */
@Data
public class WhiteListWebDTO implements Serializable {
    private static final long serialVersionUID = 8709840199265448030L;
    @ApiModelProperty(value = "ip地址",required =true)
    private String ip;
    @ApiModelProperty(value = "商户id",required =true)
    private long merchantId;
    private String id;
    private Integer pageSize;
    private Integer pageNumber;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }
}
