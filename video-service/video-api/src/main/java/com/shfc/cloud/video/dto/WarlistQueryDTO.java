package com.shfc.cloud.video.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.cloud.video.dto.WarlistDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:17
 * version V1.0.0
 */
public class WarlistQueryDTO implements Serializable {

    private Long id;//war包ID
    private String warName;//war包名称
    private Long size;//大小
    private String createTime;//上传时间
    private String status;//使用状态
    private String warVersion;//war包版本

    public String getWarVersion() {
        return warVersion;
    }

    public void setWarVersion(String warVersion) {
        this.warVersion = warVersion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarName() {
        return warName;
    }

    public void setWarName(String warName) {
        this.warName = warName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
