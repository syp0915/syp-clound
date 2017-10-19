package com.shfc.cloud.video.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.video.domain.AttachMerchant.java
 * @Description: 商户附件中间表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 13:41
 * version v1.0.0
 */
public class AttachMerchant extends BaseBean {
    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 频道编号
     */
    private String channelNo;

    /**
     * 附件ID
     */
    private Long attachId;

    /**
     * 0:待初审 1:待复审 2:带三审  3:审核通过 4:审核不通过
     */
    private Integer status;

    /**
     * 备注
     */
    private String descContent;

    /**
     * 获取商户ID
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户ID
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取频道编号
     *
     * @return channel_no
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 设置频道编号
     *
     * @param channelNo
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    /**
     * 获取附件ID
     *
     * @return attach_id
     */
    public Long getAttachId() {
        return attachId;
    }

    /**
     * 设置附件ID
     *
     * @param attachId
     */
    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    /**
     * 获取0:待初审 1:待复审 2:带三审  3:审核通过 4:审核不通过
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:待初审 1:待复审 2:带三审  3:审核通过 4:审核不通过
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return desc
     */
    public String getDescContent() {
        return descContent;
    }

    /**
     * 设置备注
     *
     * @param descContent
     */
    public void setDescContent(String descContent) {
        this.descContent = descContent == null ? null : descContent.trim();
    }
}