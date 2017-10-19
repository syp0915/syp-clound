package com.shfc.cloud.monitor.constant;

/**
 * @Package com.shfc.cloud.container.constant.ContainerErrorConstant
 * @Description:监控时间模式enum
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/17 9:43
 * version V1.0.0
 */
public enum TimeTypeEnum {
    MINUTE_60(1,"60m"),
    HOUR_24(2,"24h");

    private final int value;
    private final String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    TimeTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (TimeTypeEnum constant : TimeTypeEnum.values()) {
                if (constant.value == value) {
                    return constant.name;
                }
            }
        }
        return "";
    }

    public TimeTypeEnum getTypeByValue(int value) {
        for (TimeTypeEnum constant : TimeTypeEnum.values()) {
            if (constant.value == value) {
                return constant;
            }
        }
        return null;
    }

}
