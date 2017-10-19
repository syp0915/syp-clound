package com.shfc.cloud.account.constant;

/**
 * @Package com.shfc.cloud.account.constant.AttachConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 13:24
 * version V1.0.0
 */
public enum  AttachConstant {

    Image(0,"图片"),
    Video(1,"视频"),
    Other(2,"其他");
    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    AttachConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (AttachConstant constant : AttachConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public AttachConstant getTypeByValue(int value) {
        for (AttachConstant constant : AttachConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
