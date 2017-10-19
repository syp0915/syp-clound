package com.shfc.cloud.keywords.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *频道号/频道名称联想DTO
 * @author wky
 * @version V1.0
 * @create 2017-03-23 14:13
 **/
@ApiModel(value = "ChannelNameDTO")
public class ChannelNameDTO {
    @ApiModelProperty(value = "关键词",required = true)
    private String keyword;
    @ApiModelProperty(value = "查询显示数",required = true)
    private Integer num;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
