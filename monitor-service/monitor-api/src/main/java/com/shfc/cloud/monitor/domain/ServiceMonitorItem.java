package com.shfc.cloud.monitor.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.cloud.monitor.domain.ServiceMonitorItem.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/03/23 14:43
 * version v1.0.0
 */
public class ServiceMonitorItem extends BaseBean {
    private Long merchantId;

    private String channelId;

    private String hostName;

    private String hostId;

    private String cpuItemId;

    private String memoryItemId;

    private String diskItemId;

    private String column14;

    /**
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return channel_id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * @param channelId
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * @return host_name
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * @param hostName
     */
    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    /**
     * @return host_id
     */
    public String getHostId() {
        return hostId;
    }

    /**
     * @param hostId
     */
    public void setHostId(String hostId) {
        this.hostId = hostId == null ? null : hostId.trim();
    }

    /**
     * @return cpu_item_id
     */
    public String getCpuItemId() {
        return cpuItemId;
    }

    /**
     * @param cpuItemId
     */
    public void setCpuItemId(String cpuItemId) {
        this.cpuItemId = cpuItemId == null ? null : cpuItemId.trim();
    }

    /**
     * @return memory_item_id
     */
    public String getMemoryItemId() {
        return memoryItemId;
    }

    /**
     * @param memoryItemId
     */
    public void setMemoryItemId(String memoryItemId) {
        this.memoryItemId = memoryItemId == null ? null : memoryItemId.trim();
    }

    /**
     * @return disk_item_id
     */
    public String getDiskItemId() {
        return diskItemId;
    }

    /**
     * @param diskItemId
     */
    public void setDiskItemId(String diskItemId) {
        this.diskItemId = diskItemId == null ? null : diskItemId.trim();
    }

    /**
     * @return Column_14
     */
    public String getColumn14() {
        return column14;
    }

    /**
     * @param column14
     */
    public void setColumn14(String column14) {
        this.column14 = column14 == null ? null : column14.trim();
    }
}