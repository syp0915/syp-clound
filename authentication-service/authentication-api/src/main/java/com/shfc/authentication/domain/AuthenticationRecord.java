package com.shfc.authentication.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.authentication.domain.authenticationRecord.java
 * @Description: 身份认证记录
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016
 * All right reserved.
 * Author xiehb
 * @date 2017/03/14 17:00
 * version v1.0.0
 */
public class AuthenticationRecord extends BaseBean {
    /**
     * 商户Id
     */
    private Long merchantId;

    /**
     * 频道号
     */
    private String channelNo;

    /**
     * 省份Id
     */
    private Long provinceId;

    /**
     * 省份名称
     */
    private String province;

    /**
     * 0:男 1:女
     */
    private Integer sex;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idcard;

    /**
     * 实名验证通道(0:京东万象)
     */
    private Integer channel;

    /**
     * 0-成功 1-失败 2-异常
     */
    private Integer status;

    /**
     * 获取商户Id
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户Id
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    /**
     * 获取省份Id
     *
     * @return province_id
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省份Id
     *
     * @param provinceId
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取省份名称
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份名称
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取0:男 1:女
     *
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置0:男 1:女
     *
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取姓名
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取身份证号码
     *
     * @return idcard
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号码
     *
     * @param idcard
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 获取实名验证通道(0:京东万象)
     *
     * @return channel
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * 设置实名验证通道(0:京东万象)
     *
     * @param channel
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * 获取0-成功 1-失败 2-异常
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0-成功 1-失败 2-异常
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @Title toString
     * @Author xiehb
     * @Date 2017/03/14 17:00
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantId=").append(merchantId);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", province=").append(province);
        sb.append(", sex=").append(sex);
        sb.append(", name=").append(name);
        sb.append(", idcard=").append(idcard);
        sb.append(", channel=").append(channel);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}