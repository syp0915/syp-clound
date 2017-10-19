package com.shfc.cloud.monitor.constant;

/**
 * @Package com.shfc.cloud.container.constant.ContainerErrorConstant
 * @Description: 资源类型enum
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/17 9:43
 * version V1.0.0
 */
public enum ResourceTypeEnum {
    CPU(1,"cpu"),
//    DB(2,"db"),
    DISK(3,"disk"),
    TOMCAT(4,"tomcat")
    ;

    private final int value;
    private final String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    ResourceTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ResourceTypeEnum constant : ResourceTypeEnum.values()) {
                if (constant.value == value) {
                    return constant.name;
                }
            }
        }
        return "";
    }

    public ResourceTypeEnum getTypeByValue(int value) {
        for (ResourceTypeEnum constant : ResourceTypeEnum.values()) {
            if (constant.value == value) {
                return constant;
            }
        }
        return null;
    }

}
