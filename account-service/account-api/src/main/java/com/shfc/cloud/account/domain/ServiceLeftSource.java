package com.shfc.cloud.account.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.cloud.account.domain.ServiceLeftSource.java
 * @Description: 商户余量表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016
 * All right reserved.
 * Author liaozm
 * @date 2017/04/21 16:48
 * version v1.0.0
 */
public class ServiceLeftSource extends BaseBean {
    /**
     * 服务类型id
     */
    private Long typeId;

    /**
     * 服务类型名称
     */
    private String typeName;

    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 商户号
     */
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
     * 昵称（主要用于图片空间命名）
     */
    private String name;

    /**
     * 配置状态 0-待处理 1-配置中 2-已开通
     */
    private Integer status;

    /**
     * 余量
     */
    private Double leftNum;

    /**
     * 总量
     */
    private Double totalNum;

    /**
     * 调用ip地址
     */
    private String ip;

    /**
     * 开通时间
     */
    private Date openTime;

    /**
     * 失效时间
     */
    private Date endTime;

    /**
     * 获取服务类型id
     *
     * @return type_id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置服务类型id
     *
     * @param typeId
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取服务类型名称
     *
     * @return type_name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置服务类型名称
     *
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 获取商户id
     *
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户id
     *
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取商户号
     *
     * @return merchant_number
     */
    public String getMerchantNumber() {
        return merchantNumber;
    }

    /**
     * 设置商户号
     *
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
     * 获取昵称（主要用于图片空间命名）
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置昵称（主要用于图片空间命名）
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取配置状态 0-待处理 1-配置中 2-已开通
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置配置状态 0-待处理 1-配置中 2-已开通
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取余量
     *
     * @return left_num
     */
    public Double getLeftNum() {
        return leftNum;
    }

    /**
     * 设置余量
     *
     * @param leftNum
     */
    public void setLeftNum(Double leftNum) {
        this.leftNum = leftNum;
    }

    /**
     * 获取总量
     *
     * @return total_num
     */
    public Double getTotalNum() {
        return totalNum;
    }

    /**
     * 设置总量
     *
     * @param totalNum
     */
    public void setTotalNum(Double totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * 获取调用ip地址
     *
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置调用ip地址
     *
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取开通时间
     *
     * @return open_time
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 设置开通时间
     *
     * @param openTime
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取失效时间
     *
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置失效时间
     *
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}