package com.shfc.cloud.video.constant;

/**
 * @Package com.shfc.cloud.video.constant.ContainerStateConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:21
 * version V1.0.0
 */
public enum ContainerStateConstant {
    Empty(0,"空状态"),
    Run(1,"运行中状态");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ContainerStateConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ContainerStateConstant constant : ContainerStateConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public ContainerStateConstant getTypeByValue(int value) {
        for (ContainerStateConstant constant : ContainerStateConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
