package com.shfc.authentication.enums;

/**
 * @Package com.shfc.sms.enums.SmsLogType
 * @Description: 响应码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:48
 * version V1.0.0
 */
public enum ResStatus {
    SUCCESS("成功", "80001200001");

    private final String name;
    private final String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    ResStatus(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(String val) {
        if (val != null) {
            String value = val;
            for (ResStatus status : ResStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public ResStatus getTypeByValue(String value) {
        for (ResStatus status : ResStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }

}
