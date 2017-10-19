package com.shfc.cloud.constant;

/**
 * @Package com.shfc.cloud.constant.ErrorConstant
 * @Description: 错误对照码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/17 9:43
 * version V1.0.0
 */
public enum  ErrorConstant {
    BAD_REQUEST(400, "Bad Request!"),
    NOT_AUTHORIZATION(401, "NotAuthorization"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    RUNTIME_EXCEPTION(1000, "[服务器]运行时异常"),
    NULL_POINTER_EXCEPTION(1001, "[服务器]空值异常"),
    CLASS_CAST_EXCEPTION(1002, "[服务器]数据类型转换异常"),
    IO_EXCEPTION(1003, "[服务器]IO异常"),
    NO_SUCH_METHOD_EXCEPTION(1004, "[服务器]未知方法异常"),
    INDEX_OUT_OF_BOUNDS_EXCEPTION(1005, "[服务器]数组越界异常"),
    CONNECT_EXCEPTION(1006, "[服务器]网络异常"),
    ERROR_MEDIA_TYPE(1007, "[服务器]Content-type错误，请使用application/json"),
    EMPTY_REQUEST_BOYD(1008, "[服务器]request请求body不能为空"),
    ERROR_REQUEST_BOYD(1009, "[服务器]request请求body非json对象"),


    ERROR_VERSION(2000, "[服务器]版本号错误"),
    NULL_API_KEY(2001, "[服务器]apiKey不能为空"),
    NOT_EXIST_API_KEY(2002, "[服务器]apiKey不存在"),
    NULL_REQ_JSON(2003, "[服务器]reqJson不能为空"),
    ERROR_REQ_JSON(2004, "[服务器]reqJson格式错误"),
    NULL_TIMESTAMP(2005, "[服务器]timestamp不能为空"),
    ERROR_TIMESTAMP(2006, "[服务器]timestamp格式错误"),
    NULL_SIGNATURE(2007, "[服务器]signature不能为空"),
    ERROR_SIGNATURE(2008, "[服务器]signature格式错误"),
    VERIFY_SIGNATURE_FAILED(2009, "[服务器]验签失败"),
    ERROR_CHANNEL_NO(2010, "[服务器]该频道非当前用户所有"),
    INVALID_MERCHANT(2011,"[服务器]无效商户"),
    NULL_CHANNEL_NO(2012, "[服务器]频道号不能为空"),
    NULL_RESOURCE_TYPE(2013, "[服务器]资源类型不能为空"),
    NULL_WAR_ID(2014, "[服务器]war包ID不能为空"),
    NULL_WAR_NAME(2015, "[服务器]war包名称不能为空"),
    NAME_NOT_NULL(2016,"[服务器]姓名不能为空"),
    ID_NOT_NULL(2017,"[服务器]身份证号码不能为空"),
    INVALID_CHANNEL_NO(2018, "[服务器]无效频道"),
    DIFF_CHANNEL_NO(2019, "[服务器]频道与商户不一致"),
    ERROR_RESOURCE_TYPE(2020, "[服务器]资源类型错误"),

    NULL_MERCHANTNO(25001,"[账户应用日志]商户编号不存在"),
    NULL_ACCOUNT_PAGESIZE(25002,"[账户应用日志]每页条数不存在"),
    NULL_ACCOUNT_PAGENUMBER(25003,"[账户应用日志]当前页码不存在"),

    NULL_ENVIROMENT(30001,"[媒资应用日志]环境不能为空"),
    ERROR_ENVIROMENT(30002,"[媒资应用日志]环境枚举获取错误"),
    NULL_WARID(30003,"[媒资应用日志]warID不能为空"),
    NULL_IMAGEURL(30004,"[媒资应用日志]ImageUrl不能为空"),
    ERROR_SIZE_HEIGHT(30005,"[媒资应用日志]高度和比例选其一"),
    ERROR_APPROVERID(30006,"[媒资应用日志]审核人不能为空"),
    ERROR_CHECK_STAUS(30007,"[媒资应用日志]审批状态不能为空"),
    ERROR_NULL_REASON(30008,"[媒资应用日志]当状态是不通过，理由必填"),
    ERROR_STATUS(30009,"[媒资应用日志]状态值不对"),
    NULL_ISCLEAR(30010,"[媒资应用日志]是否清除不能为空"),
    NULL_FILE_TYPE(30011,"[媒资应用日志]附件类型不能为空"),
    ERROR_FILE_TYPE(30012,"[媒资应用日志]附件类型错误"),
    NULL_FIELDID(30013,"[媒资应用日志]资源ID不能为空"),
    NULL_VIDEO_PAGESIZE(30014,"[媒资应用日志]每页条数不存在"),
    NULL_VIDEO_PAGENUMBER(30015,"[媒资应用日志]每页条数不存在"),

    NULL_MERCHANT_ID(3000, "[商户应用日志]商户id不存在"),
    ERROR_FILE_PATH(3001, "[商户应用日志]文件路径错误"),
    EXCEPTION_APP_LOG(3002, "[商户应用日志]服务访问异常"),
    NULL_PARAMETER(3003,"必传参数不能为空");

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ErrorConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ErrorConstant constant : ErrorConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public ErrorConstant getTypeByValue(int value) {
        for (ErrorConstant constant : ErrorConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }

}
