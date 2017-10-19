package com.shfc.authentication.enums;

/**
 * @Package com.shfc.sms.enums.SmsLogType
 * @Description: 短信通道
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:48
 * version V1.0.0
 */
public enum AuthType {
    NO_PHOTO("0000", 0);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    AuthType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (AuthType type : AuthType.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public AuthType getTypeByValue(int value) {
        for (AuthType type : AuthType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

}
