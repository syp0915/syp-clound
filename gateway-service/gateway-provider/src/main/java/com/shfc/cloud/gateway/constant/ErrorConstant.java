package com.shfc.cloud.gateway.constant;

/**
 * @Package com.shfc.cloud.constant.ErrorConstant
 * @Description: 错误对照码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/17 9:43
 * version V1.0.0
 */
public enum ErrorConstant {
    UNKNOWN_ERROR(26001,"未知错误"),
    DATABASE_ERROR_OCCURRED(26002,"数据库操作出错，请重试");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ErrorConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ErrorConstant constant : ErrorConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public ErrorConstant getTypeByValue(int value) {
        for (ErrorConstant constant : ErrorConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }

}
