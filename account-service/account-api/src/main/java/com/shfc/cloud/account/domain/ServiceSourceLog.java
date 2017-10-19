package com.shfc.cloud.account.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.account.domain.ServiceSourceLog.java
 * @Description: 商户服务增量
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 15:30
 * version v1.0.0
 */
public class ServiceSourceLog extends BaseBean {
    /**
     * 调用类型 1-短信 2-语音验证码 3-图片文件存储 4-身份认证
     */
    private Long typeId;

    /**
     * 服务名称
     */
    private String typeName;

    /**
     * 昵称  （主要用于图片空间命名）
     */
    private String name;

    /**
     * 商户id
     */
    private Integer merchantId;

    private String merchantNumber;

    /**
     * 频道id
     */
    private Long channelId;

    /**
     * 频道编号
     */
    private String channelNumber;

    /**
     * 增减数量 
     */
    private Double num;

    /**
     * 获取调用类型 1-短信 2-语音验证码 3-图片文件存储 4-身份认证
     *
     * @return type_id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置调用类型 1-短信 2-语音验证码 3-图片文件存储 4-身份认证
     *
     * @param typeId
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取服务名称
     *
     * @return type_name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置服务名称
     *
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 获取昵称  （主要用于图片空间命名）
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置昵称  （主要用于图片空间命名）
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取商户id
     *
     * @return merchant_id
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户id
     *
     * @param merchantId
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return merchant_number
     */
    public String getMerchantNumber() {
        return merchantNumber;
    }

    /**
     * @param merchantNumber
     */
    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber == null ? null : merchantNumber.trim();
    }

    /**
     * 获取频道id
     *
     * @return channel_id
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 设置频道id
     *
     * @param channelId
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取频道编号
     *
     * @return channel_number
     */
    public String getChannelNumber() {
        return channelNumber;
    }

    /**
     * 设置频道编号
     *
     * @param channelNumber
     */
    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber == null ? null : channelNumber.trim();
    }

    /**
     * 获取增减数量 
     *
     * @return num
     */
    public Double getNum() {
        return num;
    }

    /**
     * 设置增减数量 
     *
     * @param num
     */
    public void setNum(Double num) {
        this.num = num;
    }
}