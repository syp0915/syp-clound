package com.shfc.cloud.keywords.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-24 14:48
 **/
@ApiModel(value = "PlotNameDTO")
public class PlotNameDTO {
    @ApiModelProperty(value = "关键词",required = true)
    private String keyword;
    @ApiModelProperty(value = "区域Id",required = false)
    private String districtId;
    @ApiModelProperty(value = "板块Id",required = false)
    private String blockId;
    @ApiModelProperty(value = "查询查询限制条数",required = true)
    private Integer num;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
