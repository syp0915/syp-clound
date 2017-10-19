package com.shfc.mac.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.mac.dto.MacDetailRemoteDTO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/28 20:05
 * version V1.0.0
 */
public class MacDetailRemoteDTO implements Serializable {
    private String resMessage;
    private MacInfoDTO result = new MacInfoDTO();
    private String resStatus;

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public MacInfoDTO getResult() {
        return result;
    }

    public void setResult(MacInfoDTO result) {
        this.result = result;
    }

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }
}
