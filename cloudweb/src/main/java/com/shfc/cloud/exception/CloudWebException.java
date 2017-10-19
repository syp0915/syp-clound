package com.shfc.cloud.exception;

/**
 * @Package com.shfc.cloud.exception.CloudWebException
 * @Description: CloudWebException
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/22 10:10
 * version V1.0.0
 */
public class CloudWebException extends Exception{
    private static final long serialVersionUID = -8198281171334131008L;

    private int errCode;

    public CloudWebException() {}

    public CloudWebException(int errCode, String message,
                        Exception exception) {
        super(message, exception);

        this.errCode = errCode;
    }

    public CloudWebException(int errCode, String message) {
        this(errCode, message,null);
    }

    public int getErrCode() {
        return this.errCode;
    }
}
