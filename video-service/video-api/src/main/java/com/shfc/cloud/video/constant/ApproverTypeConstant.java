package com.shfc.cloud.video.constant;

/**
 * @Package com.shfc.cloud.video.constant.ApproverTypeConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 15:28
 * version V1.0.0
 */
public enum ApproverTypeConstant {
    Create(0,"创建"),
    First(1,"初审"),
    Second(2,"二审"),
    Three(3,"三审");
    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ApproverTypeConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ApproverTypeConstant constant : ApproverTypeConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public static ApproverTypeConstant getConstantByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ApproverTypeConstant constant : ApproverTypeConstant.values()) {
                if (constant.code == value) {
                    return constant;
                }
            }
        }
        return null;
    }

    public ApproverTypeConstant getTypeByValue(int value) {
        for (ApproverTypeConstant constant : ApproverTypeConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
