package com.shfc.sms.enums;

import com.shfc.common.base.ValidateHelper;

/**
 * @Package com.shfc.sms.enums.SmsErrorCode
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/5 11:34
 * version V1.0.0
 */
public enum  SmsErrorCode {
    PARAMETER_NOT_NULL("[短信服务]必填参数不能为空",20000),
    SMS_OPERATOR_ERROR("[短信服务]运营商返回的错误",20005),
    VOICE_LENGTH_ERROR("[短信服务]语音验证码必须是4~6位阿拉伯数字！",20006),
    PHONE_FORMAT_ERROR("[短信服务]手机号格式不正确！",20007),
    PHONE_MULTI_ERROR("[短信服务]手机号个数和内容数量不匹配！",20008),
    ENTITY_IS_NULL("[短信服务]数据库实体类不存在!",20009),
    SIGN_ID_NOT_NULL("[短信服务]签名ID不能为空！",20010),
    SIGN_ERROR_INCLUDE("[短信服务]签名不能包含【】",20011),
    SIGN_ERROR_LENGTH("[短信服务]签名只能3到8个字!",20012),
    SIGN_ERROR_CONTENT("[短信服务]签名内容不合法!",20013),
    SMS_MARGIN_LOW("[短信服务]短信剩余条数不足，请充值！",20014),
    SMS_MARGIN_LOW_WARN("[短信服务]短信内容过长，短信剩余条数可能不足，请充值！",20015),
    MERCHANT_MARGIN_ERROR("[短信服务] 商户余量信息不正确！",20016);



    private final String msg;
    private final int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    SmsErrorCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public static String getMsgByCode(Integer cod) {
        if (cod != null) {
            int code = cod;
            for (SmsErrorCode type : SmsErrorCode.values()) {
                if (type.code == code) {
                    return type.msg;
                }
            }
        }
        return "";
    }
    public static Integer getValueByName(String name) {
        if (!ValidateHelper.isEmpty(name)) {
            String value = name;
            for (SmsErrorCode status : SmsErrorCode.values()) {
                if (status.msg.equals(value)) {
                    return status.code;
                }
            }
        }
        return null;
    }

    public SmsErrorCode getTypeByCode(int code) {
        for (SmsErrorCode type : SmsErrorCode.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return null;
    }
}
