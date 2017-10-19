package com.shfc.cloud.gateway.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package: com.shfc.cloud.gateway.domain.SensitiveWord.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/23 16:35
 * version v1.0.0
 */
@Data
public class SensitiveWord implements Serializable {
    private static final long serialVersionUID = 8983614834917801999L;
    private String sensitiveWord;
    private String status;
    private Long id;
    private Long creater;
    private String createTime;
    private Long modifier;
    private String modifyTime;
    private Long version;



}