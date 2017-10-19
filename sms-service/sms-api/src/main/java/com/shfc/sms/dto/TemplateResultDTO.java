package com.shfc.sms.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *短信模板返回结果
 * @author wky
 * @version V1.0
 * @create 2017-03-03 17:53
 **/
public class TemplateResultDTO implements Serializable{

    private static final long serialVersionUID = -8625481283025399487L;
    private Long tplId;
    private String tplContent;
    private String checkStatus;
    private String reason;

    public Long getTplId() {
        return tplId;
    }

    public void setTplId(Long tplId) {
        this.tplId = tplId;
    }

    public String getTplContent() {
        return tplContent;
    }

    public void setTplContent(String tplContent) {
        this.tplContent = tplContent;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
