package com.shfc.cloud.monitor.constant;

/**
 * @Package com.shfc.cloud.container.constant.ContainerErrorConstant
 * @Description: 错误对照码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/17 9:43
 * version V1.0.0
 */
public enum MonitorErrorConstant {
    VIRTUAL_NOT_EXIT(27000, "[监控模块]频道虚拟机不存在"),
    ZABBIX_CALL_ERROR(27001, "[监控模块]监控数据获取异常"),
    NOT_GET_MONITOR_DATA(27002, "[监控模块]未获取到监控数据"),
    ERROR_ADD_CACHE_RECORD(27003, "[监控模块]添加缓存调用记录失败"),
    DATABASE_NOT_EXIT(270004, "[监控模块]频道数据库信息不存在"),
    ITEM_ID_NOT_EXIT(270005, "[监控模块]监控项信息不存在"),
    RESOURCE_TYPE_NOT_SUPORT(270006, "[监控模块]不支持资源监控项查询");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    MonitorErrorConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (MonitorErrorConstant constant : MonitorErrorConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public MonitorErrorConstant getTypeByValue(int value) {
        for (MonitorErrorConstant constant : MonitorErrorConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }

}
