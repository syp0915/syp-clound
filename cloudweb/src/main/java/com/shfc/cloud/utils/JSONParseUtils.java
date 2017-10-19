package com.shfc.cloud.utils;

import com.alibaba.fastjson.JSON;
import com.shfc.cloud.constant.ErrorConstant;
import com.shfc.cloud.exception.CloudWebException;

/**
 * @Package com.shfc.cloud.utils.JSONParseUtils
 * @Description: JSONParseUtils
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/30 20:02
 * version V1.0.0
 */
public class JSONParseUtils {
    public static <T> T parseJavaObject(String jsonStr, Class<T> clazz) throws CloudWebException{
        try {
            return JSON.parseObject(jsonStr, clazz);
        }catch (Exception e){
            throw new CloudWebException(ErrorConstant.ERROR_REQ_JSON.getCode(),
                    ErrorConstant.ERROR_REQ_JSON.getMsg());
        }
    }
}
