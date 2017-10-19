package com.shfc.authentication.enums;

/**
 * @Package com.shfc.mail.enums.EmailErrorCode
 * @Description: 错误码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author 吴开阳
 * @date 17/3/22 10:21
 * version V1.0.0
 */
public enum AuthenticationErrorCode {

    NAME_NOT_NULL("[实名验证服务]姓名不能为空", 21000),
    ID_NOT_NULL("[实名验证服务]身份证号码不能为空", 21001),
    JDWX_ERROR("[实名验证服务]调用京东实名认证异常",21002),
    RECORD_ERROR("[实名验证服务]实名认证记录保存异常",21003),
    ID_CHECK_ERROR("[实名验证服务]身份证校验错误",21004),
    JSON_EXCEPTION("[实名验证服务]json对象转换异常",21005),
    MERCHANTID_NOT_NULL("[实名验证服务]缺少商户id参数",21006),
    CHANNELNO_NOT_NULL("[实名验证服务]缺少频道号参数",21007);

    private final String msg;
    private final int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    AuthenticationErrorCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public static String getMsgByCode(Integer cod) {
        if (cod != null) {
            int code = cod;
            for (AuthenticationErrorCode type : AuthenticationErrorCode.values()) {
                if (type.code == code) {
                    return type.msg;
                }
            }
        }
        return "";
    }

    public AuthenticationErrorCode getTypeByCode(int code) {
        for (AuthenticationErrorCode type : AuthenticationErrorCode.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return null;
    }
}
