package com.shfc.cloud.cloudbase.domain;

import com.shfc.common.httpbean.BaseBean;

import java.util.Date;

/**
 * @Package: com.shfc.cloud.container.domain.SourceVirtual.java
 * @Description: 资源——虚拟机
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/22 15:30
 * version v1.0.0
 */
public class SourceVirtual extends BaseBean {
    /**
     * 频道id
     */
    private Long channelId;

    /**
     * 频道号
     */
    private String channelNumber;

    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 商户号
     */
    private String merchantNumber;

    /**
     * 虚拟机编号
     */
    private String number;

    /**
     * 虚拟机名称
     */
    private String name;

    /**
     * 虚拟机类型 1-中型机 2-大型机 3-超大型
     */
    private Integer type;

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
     * 配置状态
     */
    private Integer status;

    /**
     * cpu规格
     */
    private String cpu;

    /**
     * 磁盘存储空间
     */
    private String rom;

    /**
     * 运行内存大小
     */
    private String ram;

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
     * @return channel_number
     */
    public String getChannelNumber() {
        return channelNumber;
    }

    /**
     * 设置频道号
     *
     * @param channelNumber
     */
    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber == null ? null : channelNumber.trim();
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
     * 获取虚拟机编号
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置虚拟机编号
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 获取虚拟机名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置虚拟机名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取虚拟机类型 1-中型机 2-大型机 3-超大型
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置虚拟机类型 1-中型机 2-大型机 3-超大型
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
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

    /**
     * 获取配置状态
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置配置状态
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取cpu规格
     *
     * @return cpu
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * 设置cpu规格
     *
     * @param cpu
     */
    public void setCpu(String cpu) {
        this.cpu = cpu == null ? null : cpu.trim();
    }

    /**
     * 获取磁盘存储空间
     *
     * @return rom
     */
    public String getRom() {
        return rom;
    }

    /**
     * 设置磁盘存储空间
     *
     * @param rom
     */
    public void setRom(String rom) {
        this.rom = rom == null ? null : rom.trim();
    }

    /**
     * 获取运行内存大小
     *
     * @return ram
     */
    public String getRam() {
        return ram;
    }

    /**
     * 设置运行内存大小
     *
     * @param ram
     */
    public void setRam(String ram) {
        this.ram = ram == null ? null : ram.trim();
    }
}