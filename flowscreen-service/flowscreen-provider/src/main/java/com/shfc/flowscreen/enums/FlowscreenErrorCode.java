package com.shfc.flowscreen.enums;

/**
 * @Package com.shfc.flowscreen.enums.FlowscreenErrorCode
 * @Description: FlowscreenErrorCode
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/23 下午3:32
 * version V1.0.0
 */
public enum FlowscreenErrorCode {

    MERCHANTID_NOT_NULL("[飘屏服务]商户id不能为空",24000),
    CHANNELNO_NOT_NULL("[飘屏服务]频道号不能为空",24001),
    MAC_NOT_NULL("[飘屏服务]Mac地址不能为空",24002),
    URL_NOT_NULL("[飘屏服务]资源url不能为空",24003),
    FLOWSCREEN_SAVE_ERROR("[飘屏服务]飘屏调用记录保存异常",24004),
    FLOWSCREEN_REQ_ERROR("[飘屏服务]飘屏调用异常：",24005);

    private final String msg;
    private final int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    FlowscreenErrorCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public static String getMsgByCode(Integer cod) {
        if (cod != null) {
            int code = cod;
            for (FlowscreenErrorCode type : FlowscreenErrorCode.values()) {
                if (type.code == code) {
                    return type.msg;
                }
            }
        }
        return "";
    }

    public FlowscreenErrorCode getTypeByCode(int code) {
        for (FlowscreenErrorCode type : FlowscreenErrorCode.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return null;
    }
}
