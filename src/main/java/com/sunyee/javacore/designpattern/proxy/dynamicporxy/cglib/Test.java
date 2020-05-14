package com.sunyee.javacore.designpattern.proxy.dynamicporxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 *JDK中提供的生成动态代理类的机制有个鲜明的特点是： 某个类必须有实现的接口，而生成的代理类也只能代理某个类接口定义的方法，
 * 比如：如果上面例子的ElectricCar实现了继承自两个接口的方法外，另外实现了方法bee() ,则在产生的动态代理类中不会有这个方法
 * 了！更极端的情况是：如果某个类没有实现接口，那么这个类就不能用JDK产生动态代理了！
 *
 *
 * cglib 创建某个类A的动态代理类的模式是：
 *
 * 1.   查找A上的所有非final 的public类型的方法定义；
 *
 * 2.   将这些方法的定义转换成字节码；
 *
 * 3.   将组成的字节码转换成相应的代理的class对象；
 *
 * 4.   实现 MethodInterceptor接口，用来处理 对代理类上所有方法的请求（这个接口和JDK动态代理InvocationHandler的功能和角色是一样的）
 * Created by lishunyi on 2019/7/30
 */
public class Test {

    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        Hacker hacker = new Hacker();
        //属于cglib的加强器， 用以创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(programmer.getClass());
        //设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();
<<<<<<< HEAD
=======

>>>>>>> 69e81ebaf5f10d2f02c787dc6e09a6368fd24275
    }
}
