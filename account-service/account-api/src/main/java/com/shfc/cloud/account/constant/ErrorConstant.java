package com.shfc.cloud.account.constant;

/**
 * @Package com.shfc.cloud.notify.constant.ErrorConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/4/25 9:41
 * version V1.0.0
 */
public enum ErrorConstant {
    BAD_REQUEST(400, "Bad Request!"),
    NOT_AUTHORIZATION(401, "NotAuthorization"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    APIKEY_NULL_ERROR(25001, "请求参数APIEKY错误！");

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
