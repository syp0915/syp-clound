package com.shfc.cloud.account.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.account.domain.ServiceType.java
 * @Description: 服务类型
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/03/25 15:30
 * version v1.0.0
 */
public class ServiceType extends BaseBean {
    /**
     * 服务名称
     */
    private String name;

    /**
     * 单位扣费数量
     */
    private Double feeNum;

    /**
     * 扣费单位
     */
    private String feeUnit;

    /**
     * 是否为余量弹性商品 0-否 1-是
     */
    private Boolean isStretch;

    /**
     * 获取服务名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置服务名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取单位扣费数量
     *
     * @return fee_num
     */
    public Double getFeeNum() {
        return feeNum;
    }

    /**
     * 设置单位扣费数量
     *
     * @param feeNum
     */
    public void setFeeNum(Double feeNum) {
        this.feeNum = feeNum;
    }

    /**
     * 获取扣费单位
     *
     * @return fee_unit
     */
    public String getFeeUnit() {
        return feeUnit;
    }

    /**
     * 设置扣费单位
     *
     * @param feeUnit
     */
    public void setFeeUnit(String feeUnit) {
        this.feeUnit = feeUnit == null ? null : feeUnit.trim();
    }

    /**
     * 获取是否为余量弹性商品 0-否 1-是
     *
     * @return is_stretch
     */
    public Boolean getIsStretch() {
        return isStretch;
    }

    /**
     * 设置是否为余量弹性商品 0-否 1-是
     *
     * @param isStretch
     */
    public void setIsStretch(Boolean isStretch) {
        this.isStretch = isStretch;
    }
}