package com.sunyee.javacore.framework.spring.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lishunyi on 2019/8/1
 */
public class TicketServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before_advice: 欢迎光临本售票点!");
    }
}
