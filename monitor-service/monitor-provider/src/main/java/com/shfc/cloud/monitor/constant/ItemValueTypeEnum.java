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
public enum ItemValueTypeEnum {
    CPU(0,"cpu"),
    TOMCAT(3,"tomcat"),
    DISK(3,"disk");


    private final int value;
    private final String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    ItemValueTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ItemValueTypeEnum constant : ItemValueTypeEnum.values()) {
                if (constant.value == value) {
                    return constant.name;
                }
            }
        }
        return "";
    }

    public ItemValueTypeEnum getTypeByValue(int value) {
        for (ItemValueTypeEnum constant : ItemValueTypeEnum.values()) {
            if (constant.value == value) {
                return constant;
            }
        }
        return null;
    }

}
