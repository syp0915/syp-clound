package com.shfc.cloud.gateway.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/29 9:37
 * @see 链接到其他资源
 * @since 1.0
 */
@Data
public class SourceDataInfo implements Serializable{
    private static final long serialVersionUID = 4964326102833557152L;
    private long merchantId;
    private String channelNo;
    private String user;
    private String password;
    private String name;
    private String status;
    private String ip;
}
