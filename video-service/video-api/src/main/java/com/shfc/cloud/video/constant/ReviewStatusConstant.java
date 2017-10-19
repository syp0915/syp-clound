package com.shfc.cloud.video.constant;

/**
 * @Package com.shfc.cloud.account.constant.CheckStatusConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 13:35
 * version V1.0.0
 */
public enum  ReviewStatusConstant {
    All(0,"全部"),
    PendingReview(1,"待审核"),
    Pass(2,"通过"),
    NotPass(3,"未通过");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ReviewStatusConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ReviewStatusConstant constant : ReviewStatusConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public ReviewStatusConstant getTypeByValue(int value) {
        for (ReviewStatusConstant constant : ReviewStatusConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
