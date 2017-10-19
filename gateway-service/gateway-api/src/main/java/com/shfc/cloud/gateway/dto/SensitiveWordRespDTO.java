package com.shfc.cloud.gateway.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/5/25 16:59
 * @since 1.0
 */
@Data
public class SensitiveWordRespDTO implements Serializable {
    private static final long serialVersionUID = 4746448261908569418L;
    private String sensitiveWord;
    private String status;
    private Long id;
    private Long creater;
    private String createTime;
    private Long modifier;
    private String modifyTime;
    private Long version;

}
