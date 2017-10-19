package com.shfc.sms.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.sms.dto.SmsResultDTO
 * @Description: 接受短信发送结果DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/3/3 18:04
 * version V1.0.0
 */
public class SmsResultDTO implements Serializable {
//    private Long sid;//短信主键id
    //private String msgId;//消息ID
    private Integer code;//0代表发送成功，其他code代表出错
    private String msg;//例如""发送成功""，或者相应错误信息
    private String mobile;//手机号
    private Integer count;//发送成功短信的计费条数


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    /*public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }*/

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}
