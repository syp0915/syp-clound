package com.shfc.cloud.gateway.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/27 9:44
 * @since 1.0
 */
@Data
@Getter
@Setter
public class GatewayAuthDTO implements Serializable{
    private static final long serialVersionUID = -1319411026463432756L;
    private String channelNo;
    private String startTime;
    private String endTime;
    private long merchantId;
    private int validity;
    private long id;
}
