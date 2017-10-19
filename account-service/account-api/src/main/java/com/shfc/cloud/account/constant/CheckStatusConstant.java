package com.shfc.cloud.account.constant;

/**
 * @Package com.shfc.cloud.account.constant.CheckStatusConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 13:35
 * version V1.0.0
 */
public enum  CheckStatusConstant {
    All(0,"全部"),
    Audited(1,"已审核"),
    NotAudited(2,"未审核"),
    DidNotPass(3,"未通过");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CheckStatusConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (CheckStatusConstant constant : CheckStatusConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public static CheckStatusConstant getConstantByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (CheckStatusConstant constant : CheckStatusConstant.values()) {
                if (constant.code == value) {
                    return constant;
                }
            }
        }
        return null;
    }

    public CheckStatusConstant getTypeByValue(int value) {
        for (CheckStatusConstant constant : CheckStatusConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
