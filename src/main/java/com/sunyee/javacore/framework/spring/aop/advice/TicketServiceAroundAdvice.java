package com.sunyee.javacore.framework.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by lishunyi on 2019/8/1
 */
public class TicketServiceAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("around advice: begin ....");
        Object returnValue = invocation.proceed();
        System.out.println("around advice: end ....");
        return returnValue;
    }
}
