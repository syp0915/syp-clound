package com.shfc.cloud.gateway.domain;

import com.shfc.common.httpbean.BaseBean;
import java.util.Date;

/**
 * @Package: com.shfc.cloud.gateway.domain.SourceDatabase.java
 * @Description: 资源——数据库
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/28 15:52
 * version v1.0.0
 */
public class SourceDatabase extends BaseBean {
    /**
     * 频道id
     */
    private Long channelId;

    /**
     * 频道号
     */
    private String channelNo;

    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 商户号
     */
    private String merchantNumber;

    /**
     * 数据库名称
     */
    private String name;

    /**
     * 调用ip地址
     */
    private String ip;

    /**
     * 数据库类型 MYSQLl或MONGO
     */
    private String dbType;

    /**
     * 数据库版本
     */
    private String dbVersion;

    /**
     * 数据空间
     */
    private Long space;

    /**
     * 配置状态 1-待处理 2-配置中 3-已开通
     */
    private Integer status;

    /**
     * 开通时间
     */
    private Date openTime;

    /**
     * 失效时间
     */
    private Date endTime;

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
     * 获取频道号
     *
     * @return channel_no
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 设置频道号
     *
     * @param channelNo
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
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
     * 获取数据库名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置数据库名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 获取数据库类型 MYSQLl或MONGO
     *
     * @return db_type
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * 设置数据库类型 MYSQLl或MONGO
     *
     * @param dbType
     */
    public void setDbType(String dbType) {
        this.dbType = dbType == null ? null : dbType.trim();
    }

    /**
     * 获取数据库版本
     *
     * @return db_version
     */
    public String getDbVersion() {
        return dbVersion;
    }

    /**
     * 设置数据库版本
     *
     * @param dbVersion
     */
    public void setDbVersion(String dbVersion) {
        this.dbVersion = dbVersion == null ? null : dbVersion.trim();
    }

    /**
     * 获取数据空间
     *
     * @return space
     */
    public Long getSpace() {
        return space;
    }

    /**
     * 设置数据空间
     *
     * @param space
     */
    public void setSpace(Long space) {
        this.space = space;
    }

    /**
     * 获取配置状态 1-待处理 2-配置中 3-已开通
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置配置状态 1-待处理 2-配置中 3-已开通
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
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