package com.shfc.sms.enums;

/**
 * @Package com.shfc.sms.enums.SmsLogType
 * @Description: 短信通道
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:48
 * version V1.0.0
 */
public enum ChannelType {
    YUNPIAN("云片", 0);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    ChannelType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ChannelType type : ChannelType.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public ChannelType getTypeByValue(int value) {
        for (ChannelType type : ChannelType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

}
