package com.shfc.cloud.applog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.applog.dto.AppLogDTO
 * @Description: AppLogDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/21 10:46
 * version V1.0.0
 */
@ApiModel(value = "AppLogDTO")
public class AppLogDTO{
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;
    @ApiModelProperty(value = "文件", required = false)
    private String filePath;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
