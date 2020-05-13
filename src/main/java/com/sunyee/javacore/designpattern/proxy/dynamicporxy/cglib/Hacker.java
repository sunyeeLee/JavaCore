package com.sunyee.javacore.designpattern.proxy.dynamicporxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lishunyi on 2019/7/30
 */
public class Hacker implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("code".equals(method.getName())){
            System.out.println("i am a hacker, let's see what the poor programmer is doing now!");
            methodProxy.invokeSuper(o, objects);
            System.out.println("oh, what a poor programmer!");
        } else {
            methodProxy.invokeSuper(o, objects);
        }
        return null;
    }
}
