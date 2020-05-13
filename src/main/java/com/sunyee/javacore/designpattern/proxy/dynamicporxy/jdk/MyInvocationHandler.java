package com.sunyee.javacore.designpattern.proxy.dynamicporxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lishunyi on 2019/7/30
 */
public class MyInvocationHandler implements InvocationHandler {

    private ElectricCar electricCar;

    public MyInvocationHandler(ElectricCar electricCar){
        this.electricCar = electricCar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("you are going to invoke: " + method.getName());
        method.invoke(electricCar, null);
        System.out.println(method.getName() + " invocation has been finished!!!");
        return null;
    }
}
