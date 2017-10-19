package com.shfc.sms.aspect;

import com.alibaba.fastjson.JSON;
import com.shfc.sms.manager.SmsLogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Package com.shfc.sms.aspect.SmsLogAspect
 * @Description: 日志
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 10:39
 * version V1.0.0
 */
@Component
@Aspect
public class SmsLogAspect {

    @Autowired
    private SmsLogManager smsLogManager;

    /**
     * 定义Pointcut，Pointcut的名称 此方法不能有返回值，该方法只是一个标示
     */
    @Pointcut("execution(* com.shfc.sms.yunpian..*(..))")
    public void recordLog() {
    }

    /**
     * After returning advice
     * @param joinPoint
     * @param returnValue 返回值
     */
    @AfterReturning(pointcut="recordLog()", returning="returnValue")
    public void log(JoinPoint joinPoint, Object returnValue) {

        smsLogManager.collectingLogs(joinPoint.getThis(), joinPoint.getSignature().getName(),
                joinPoint.getArgs(), returnValue);
    }
}
