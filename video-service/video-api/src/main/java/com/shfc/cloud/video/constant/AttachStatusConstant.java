package com.shfc.cloud.video.constant;

/**
 * @Package com.shfc.cloud.video.constant.AttachStatusConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 14:54
 * version V1.0.0
 */
public enum AttachStatusConstant {
    FirstReview(0,"待初审"),
    SecondReview(1,"待复审"),
    ThreeReview(2,"待三审"),
    Pass(3,"通过"),
    NotPass(4,"未通过");
    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    AttachStatusConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (AttachStatusConstant constant : AttachStatusConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public static AttachStatusConstant getConstantByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (AttachStatusConstant constant : AttachStatusConstant.values()) {
                if (constant.code == value) {
                    return constant;
                }
            }
        }
        return null;
    }

    public AttachStatusConstant getTypeByValue(int value) {
        for (AttachStatusConstant constant : AttachStatusConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
