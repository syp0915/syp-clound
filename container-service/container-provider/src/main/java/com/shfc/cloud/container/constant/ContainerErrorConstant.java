package com.shfc.cloud.container.constant;

/**
 * @Package com.shfc.cloud.container.constant.ContainerErrorConstant
 * @Description: 错误对照码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/17 9:43
 * version V1.0.0
 */
public enum ContainerErrorConstant {
    VIRTUAL_NOT_EXIT(2001, "频道虚拟机不存在"),
    WAR_DEPLOY_ERROR(2002, "war包部署处理失败"),
    WAR_ROLLBACK_ERROR(2003, "war包回滚处理失败"),
    WAR_RESTART_ERROR(2004, "war包重启失败"),
    NULL_MUST_INPUT(2005, "必填参数不能为空"),
    WAR_NOT_EXIST(2006, "war包信息不存在");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ContainerErrorConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ContainerErrorConstant constant : ContainerErrorConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public ContainerErrorConstant getTypeByValue(int value) {
        for (ContainerErrorConstant constant : ContainerErrorConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }

}
