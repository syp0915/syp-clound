package com.shfc.cloud.gateway.dto;

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
public class WhiteListDTO implements Serializable {
    private long merchantId;
    private String ip;
    private String status;
}
