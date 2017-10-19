package com.shfc.cloud.area.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-24 14:44
 **/
@ApiModel(value = "AreaDTO")
public class AreaDTO {
    @ApiModelProperty(value = "城市编号",required = true)
    private String cityId;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
