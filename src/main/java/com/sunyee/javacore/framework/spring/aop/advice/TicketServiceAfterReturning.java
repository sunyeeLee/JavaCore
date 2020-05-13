package com.sunyee.javacore.framework.spring.aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by lishunyi on 2019/8/1
 */
public class TicketServiceAfterReturning implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after_returning: 本次服务已结束!");
    }
}
