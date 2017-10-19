package com.shfc.cloud.authentication.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-21 13:55
 **/
@ApiModel(value = "AuthenticationDTO")
public class AuthenticationDTO {
    @ApiModelProperty(value = "姓名",required = true)
    private String name;
    @ApiModelProperty(value = "身份证号码",required = true)
    private String id;
    @ApiModelProperty(value = "频道号",required = true)
    private String channelNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }
}
