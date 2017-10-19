package com.shfc.sms.enums;

/**
 * @Package com.shfc.sms.enums.SmsLogType
 * @Description: 日志类型
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:48
 * version V1.0.0
 */
public enum SmsLogType {
    UNKNOWN("未知类型", 404),
    SIGN("签名操作", 0),
    TEMPLATE("模板操作", 1),
    SINGLE_SEND("单条发送", 2),
    BATCH_SEND("批量发送相同内容", 3),
    MULTI_SEND("批量发送不同内容", 4),
    VOICE_SEND("语音发送", 5),
    TPL_SINGLE_SEND("指定模板单发", 6),
    TPL_BATCH_SEND("指定模板群发", 7),
    SMS_GET_RECORD("查询短信发送记录", 8),
    SMS_GET_BLACK_WORD("查询屏蔽词", 9);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    SmsLogType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (SmsLogType type : SmsLogType.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public SmsLogType getTypeByValue(int value) {
        for (SmsLogType type : SmsLogType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

}
