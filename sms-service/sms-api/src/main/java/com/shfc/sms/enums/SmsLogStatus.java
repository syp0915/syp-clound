package com.shfc.sms.enums;

/**
 * @Package com.shfc.sms.enums.SmsLogType
 * @Description: 日志状态
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:48
 * version V1.0.0
 */
public enum SmsLogStatus {
    SUCCESS("成功", 0),
    FAILED("失败", 1),
    EXCEPTION("异常", 2);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    SmsLogStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (SmsLogStatus status : SmsLogStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public SmsLogStatus getTypeByValue(int value) {
        for (SmsLogStatus status : SmsLogStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }

}
