package com.shfc.cloud.gateway.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/23 10:02
 * @since 1.0
 */
@Data
public class SensitiveDTO implements Serializable {
    private static final long serialVersionUID = -4972467696406238128L;
    private String sensitiveWord;
    private long version;

}
