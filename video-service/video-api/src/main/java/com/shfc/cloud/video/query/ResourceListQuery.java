package com.shfc.cloud.video.query;

import com.shfc.cloud.video.constant.AttachConstant;
import com.shfc.cloud.video.constant.AttachStatusConstant;
import com.shfc.cloud.video.dto.ResourceListDTO;
import com.shfc.common.base.StringUtils;
import com.shfc.mybatis.pagination.Page;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package com.shfc.cloud.video.query.ResourceListQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:40
 * version V1.0.0
 */
public class ResourceListQuery implements Serializable {
    private Long merchantId;//商户编号
    private String channelNo;//频道号
    private AttachConstant type;//类型 0:图片 1:视频
    private Date startDate;//开始时间
    private Date endDate;//结束时间
    private AttachStatusConstant status;//状态	0:全部 1:待审核 2:通过 3:未通过
    private Page<ResourceListDTO> page = new Page<>();

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Page<ResourceListDTO> getPage() {
        return page;
    }

    public void setPage(Page<ResourceListDTO> page) {
        this.page = page;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getType() {
        return StringUtils.toString(type.getCode(),"");
    }

    public void setType(AttachConstant type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        if(status==null){
            return null;
        }else{
            return StringUtils.toString(status.getCode(),"");
        }
    }

    public void setStatus(AttachStatusConstant status) {
        this.status = status;
    }
}
