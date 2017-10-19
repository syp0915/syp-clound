package com.shfc.authentication.enums;

/**
 * @Package com.shfc.sms.enums.SmsLogType
 * @Description: 日志状态
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:48
 * version V1.0.0
 */
public enum ResultStatus {
    SUCCESS("认证通过", "0000"),
    FAIL("认证不一致", "0001"),
    PROCESSING("正在处理中","0002"),
    EXCEPTION("交易异常", "0003");

    private final String name;
    private final String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    ResultStatus(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(String val) {
        if (val != null) {
            String value = val;
            for (ResultStatus status : ResultStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public ResultStatus getTypeByValue(String value) {
        for (ResultStatus status : ResultStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }

}
