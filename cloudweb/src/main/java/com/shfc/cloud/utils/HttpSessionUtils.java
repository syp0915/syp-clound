package com.shfc.cloud.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Package com.fc.realtorAdmin.utils.HttpSessionUtils
 * @Description: session 会话工具类
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2016/10/26 16:23
 * version V1.0.0
 */
public class HttpSessionUtils {

    private static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    private static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * @Description: 存放会话级别的值
     * @Title putObject
     * @Author  lv bin
     * @Date 2016/10/26 16:29
     * @param  sessionKey, obj
     * @return void
     * @throws
     */
    public static void putObject(String sessionKey, Object obj){
        getSession().setAttribute(sessionKey, obj);
    }

    /**
     * @Description: 根据 session key获取会话值
     * @Title getObject
     * @Author  lv bin
     * @Date 2016/10/26 16:27
     * @param  sessionKey
     * @return T
     * @throws
     */
    public static <T> T  getObject(String sessionKey){
        return  (T)getSession().getAttribute(sessionKey);
    }
}
