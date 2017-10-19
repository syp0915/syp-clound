package com.shfc.authentication.aspect;

import com.shfc.authentication.manager.AuthenticationManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * aspectj拦截器
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-09 14:08
 **/
@Component
@Aspect
public class AuthenticationAspect {
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 定义Pointcut，Pointcut的名称 此方法不能有返回值，该方法只是一个标示
     */
    @Pointcut("execution(* com.shfc.authentication.sdk.service.WxService.authenticate(..))")
    public void recordLog() {
    }

    /**
     * After returning advice
     * @param joinPoint
     * @param returnValue 返回值
     */
    @AfterReturning(pointcut="recordLog()",returning="returnValue")
    public void log(JoinPoint joinPoint, Object returnValue) {

        authenticationManager.collectingLogs(joinPoint.getThis(), joinPoint.getSignature().getName(), joinPoint.getArgs(), returnValue);
    }


    /**
     * 定义Pointcut，Pointcut的名称 此方法不能有返回值，该方法只是一个标示
     */
    @Pointcut("execution(* com.shfc.authentication.utils.IdentityRemoteUtil.createRequest(..))")
    public void Log() {
    }

    /**
     * After returning advice
     * @param joinPoint
     * @param returnValue 返回值
     */
    @AfterReturning(pointcut="Log()",returning="returnValue")
    public void addLog(JoinPoint joinPoint, Object returnValue) {

        authenticationManager.rzbAddLogs(joinPoint.getThis(), joinPoint.getSignature().getName(), joinPoint.getArgs(), returnValue);
    }

}
