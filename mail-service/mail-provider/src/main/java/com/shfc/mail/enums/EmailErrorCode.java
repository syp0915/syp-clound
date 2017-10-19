package com.shfc.mail.enums;

/**
 * @Package com.shfc.mail.enums.EmailErrorCode
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/3/21 下午3:32
 * version V1.0.0
 */
public enum EmailErrorCode {

    TOEMAILS_NOT_NULL("[邮件服务]收件人不能为空", 23000),
    SUBJECT_NOT_NULL("[邮件服务]主题不能为空", 23001),
    HTMLCONTENT_NOT_NULL("[邮件服务]内容不能为空",23002),
    EMAILHOST_NOT_NULL("[邮件服务]服务器不能为空",23003),
    EMAILUSERNAME_NOT_NULL("[邮件服务]服务器用户名不能为空",23004),
    EMAILPASSWORD_NOT_NULL("[邮件服务]服务器密码不能为空",23005),
    EMAILFROM_NOT_NULL("[邮件服务]发件人邮箱不能为空",23006),
    EMAIL_FORMAT_ERR("[邮件服务]邮箱格式错误",23007),
    EMAILHOST_EMAILFROM_NOT_CON("[邮件服务]发件邮箱必须与邮箱服务保持一致",23008),
    EMAILSEND_SAVE_ERROR("[邮件服务]发送记录保存异常",23009),
    ATTA_ADD_ERROR("[邮件服务]附件添加异常：",23010),
    EMAILSEND_ERROR("[邮件服务]邮件发送异常：",23011);

    private final String msg;
    private final int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    EmailErrorCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public static String getMsgByCode(Integer cod) {
        if (cod != null) {
            int code = cod;
            for (EmailErrorCode type : EmailErrorCode.values()) {
                if (type.code == code) {
                    return type.msg;
                }
            }
        }
        return "";
    }

    public EmailErrorCode getTypeByCode(int code) {
        for (EmailErrorCode type : EmailErrorCode.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return null;
    }
}
