package com.shfc.cloud.account.constant;

/**
 * 扣除类别
 * @Package com.shfc.cloud.account.constant.DeductConstant
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/20 10:19
 * version V1.0.0
 */
public enum DeductConstant {

    Message(0,"短信",5L),
    Voice_Verification_Code(1,"语音验证码",4L),
    Certification(2,"认证",9L),
    Image(3,"图片空间",3L),
    ;

    private final int code;
    private final String msg;
    private final Long typeid;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Long getTypeid() {
        return typeid;
    }

    DeductConstant(int code, String msg,Long typeid) {
        this.code = code;
        this.msg = msg;
        this.typeid = typeid;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (DeductConstant constant : DeductConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public DeductConstant getTypeByValue(int value) {
        for (DeductConstant constant : DeductConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }
}
