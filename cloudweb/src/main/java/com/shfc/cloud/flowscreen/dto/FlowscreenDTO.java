package com.shfc.cloud.flowscreen.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Package com.shfc.apistore.flowscreen.dto.FlowscreenDTO
 * @Description: FlowscreenDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/30 上午9:28
 * version V1.0.0
 */
public class FlowscreenDTO {
    @ApiModelProperty(value = "频道号",required = false)
    private String channelNo;//频道号

    @ApiModelProperty(value = "mac地址",required = false)
    private String mac;//机顶盒Mac地址

    @ApiModelProperty(value = "url地址",required = false)
    private String url;//飘屏url地址

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
