package com.shfc.cloud.video.constant;

/**
 * @Package com.shfc.cloud.video.constant.CheckConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 15:17
 * version V1.0.0
 */
public enum CheckConstant {
    NotCheck(0,"未审核"),
    Pass(1,"审核通过"),
    NotPass(2,"审核不通过");
    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CheckConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (CheckConstant constant : CheckConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public static CheckConstant getConstantByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (CheckConstant constant : CheckConstant.values()) {
                if (constant.code == value) {
                    return constant;
                }
            }
        }
        return null;
    }

    public CheckConstant getTypeByValue(int value) {
        for (CheckConstant constant : CheckConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
