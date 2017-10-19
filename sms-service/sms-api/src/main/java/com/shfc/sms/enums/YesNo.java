package com.shfc.sms.enums;

/**
 * @Package com.shfc.sms.enums
 * @Description: 是否删除
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/10 10:46
 * version V1.0.0
 */
public enum YesNo {
    NO("否", 0), YES("是", 1);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    YesNo(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (YesNo yesNo : YesNo.values()) {
                if (yesNo.value == value) {
                    return yesNo.name;
                }
            }
        }
        return "";
    }

    public YesNo getTypeByValue(int value) {
        for (YesNo yesNo : YesNo.values()) {
            if (yesNo.value == value) {
                return yesNo;
            }
        }
        return null;
    }
}
