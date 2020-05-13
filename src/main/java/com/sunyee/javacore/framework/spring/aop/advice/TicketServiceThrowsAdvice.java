package com.sunyee.javacore.framework.spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;
import java.lang.reflect.Method;

/**
 * Created by lishunyi on 2019/8/1
 */
public class TicketServiceThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("AFTER_THROWING....");
    }
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("调用过程出错啦！！！！！");
    }

}
