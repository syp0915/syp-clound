package com.shfc.flowscreen.enums;

/**
 * @Package com.shfc.flowscreen.enums.FlowscreenStatus
 * @Description: FlowscreenStatus
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/23 下午8:21
 * version V1.0.0
 */
public enum FlowscreenStatus {
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

    FlowscreenStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (FlowscreenStatus status : FlowscreenStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public FlowscreenStatus getTypeByValue(int value) {
        for (FlowscreenStatus status : FlowscreenStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }

}
