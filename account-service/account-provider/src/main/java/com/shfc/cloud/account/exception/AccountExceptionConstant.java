package com.shfc.cloud.account.exception;

/**
 * @Package com.shfc.cloud.account.exception.AccountExceptionConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/29 12:28
 * version V1.0.0
 */
public enum AccountExceptionConstant {
    REQUEST_PARAMETER_MISS(4001, "请求参数缺失"),
    MERCHANT_NOT_NULL(4002,"请求参数商户ID和商户编号不能同时为空");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    AccountExceptionConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (AccountExceptionConstant constant : AccountExceptionConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public AccountExceptionConstant getTypeByValue(int value) {
        for (AccountExceptionConstant constant : AccountExceptionConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
