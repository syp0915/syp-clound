package com.shfc.sms.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.sms.dto.VoiceResultDTO
 * @Description: 语音验证码接收DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/6 17:45
 * version V1.0.0
 */
public class VoiceResultDTO implements Serializable {
    private String sid;//短信id
    private String count;//发送成功短信的计费条数

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
