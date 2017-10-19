package com.shfc.cloud.video.constant;

/**
 * @Package com.shfc.cloud.video.constant.ClearConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 15:19
 * version V1.0.0
 */
public enum ClearConstant {
    Clear(0,"立即清除"),
    NotClear(1,"不清除");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ClearConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ClearConstant constant : ClearConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public static ClearConstant getConstantByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ClearConstant constant : ClearConstant.values()) {
                if (constant.code == value) {
                    return constant;
                }
            }
        }
        return null;
    }

    public ClearConstant getTypeByValue(int value) {
        for (ClearConstant constant : ClearConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
