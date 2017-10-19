package com.shfc.mac.enums;

import com.shfc.common.base.ValidateHelper;

/**
 * @Package com.shfc.mac.enums.MacErrorCode
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/6 9:02
 * version V1.0.0
 */
public enum  MacErrorCode {
    PARAMETER_NOT_NULL("[MAC地址服务]必填参数不能为空",22000),
    MAC_REMOTE_ERROR("[MAC地址服务]远程调用返回的错误",20001);

    private final String msg;
    private final int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    MacErrorCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public static String getMsgByCode(Integer cod) {
        if (cod != null) {
            int code = cod;
            for (MacErrorCode type : MacErrorCode.values()) {
                if (type.code == code) {
                    return type.msg;
                }
            }
        }
        return "";
    }
    public static Integer getValueByName(String name) {
        if (!ValidateHelper.isEmpty(name)) {
            String value = name;
            for (MacErrorCode status : MacErrorCode.values()) {
                if (status.msg.equals(value)) {
                    return status.code;
                }
            }
        }
        return null;
    }

    public MacErrorCode getTypeByCode(int code) {
        for (MacErrorCode type : MacErrorCode.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return null;
    }
}
