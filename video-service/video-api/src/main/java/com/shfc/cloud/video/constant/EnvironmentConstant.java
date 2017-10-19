package com.shfc.cloud.video.constant;

/**
 * @Package com.shfc.cloud.video.constant.EnvironmentConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 13:55
 * version V1.0.0
 */
public enum EnvironmentConstant {
    Test(0,"测试环境"),
    Formal(1,"正式环境");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    EnvironmentConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (EnvironmentConstant constant : EnvironmentConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public static EnvironmentConstant getConstantByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (EnvironmentConstant constant : EnvironmentConstant.values()) {
                if (constant.code == value) {
                    return constant;
                }
            }
        }
        return null;
    }

    public EnvironmentConstant getTypeByValue(int value) {
        for (EnvironmentConstant constant : EnvironmentConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
