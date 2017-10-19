package com.shfc.cloud.video.constant;

/**
 * @Package com.shfc.cloud.video.constant.ChannelTypeConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/31 15:49
 * version V1.0.0
 */
public enum ChannelTypeConstant {
    NEWS(1,"新闻"),
    SCHOOL(2,"教育"),
    ART(3,"文艺"),
    SERVICE(4,"服务");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ChannelTypeConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ChannelTypeConstant constant : ChannelTypeConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public static ChannelTypeConstant getConstantByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ChannelTypeConstant constant : ChannelTypeConstant.values()) {
                if (constant.code == value) {
                    return constant;
                }
            }
        }
        return null;
    }

    public ChannelTypeConstant getTypeByValue(int value) {
        for (ChannelTypeConstant constant : ChannelTypeConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
