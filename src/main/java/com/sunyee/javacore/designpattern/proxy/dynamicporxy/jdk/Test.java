package com.sunyee.javacore.designpattern.proxy.dynamicporxy.jdk;

import com.sunyee.javacore.designpattern.proxy.dynamicporxy.ProxyUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * * JDK动态代理
 *  *     1.   获取 RealSubject上的所有接口列表；
 *  *     2.   确定要生成的代理类的类名，默认为：com.sun.proxy.$ProxyXXXX ；
 *  *
 *  *     3.   根据需要实现的接口信息，在代码中动态创建 该Proxy类的字节码；
 *  *
 *  *     4 .  将对应的字节码转换为对应的class 对象；
 *  *
 *  *     5.   创建InvocationHandler 实例handler，用来处理Proxy所有方法调用；
 *  *
 *  *     6.   Proxy 的class对象 以创建的handler对象为参数，实例化一个proxy对象
 * Created by lishunyi on 2019/7/30
 */
public class Test {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        //1. 获取相应的classloader
        ClassLoader classLoader = electricCar.getClass().getClassLoader();
        //2. 获取electricCar所有接口
        Class[] interfaces = electricCar.getClass().getInterfaces();
        //3. 设置一个来自代理传过来的方法调用处理器，处理所有代理类的方法调用
        InvocationHandler invocationHandler = new MyInvocationHandler(electricCar);
        /*
		  4.根据上面提供的信息，创建代理对象 在这个过程中，
                 a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
		         b.然后根据相应的字节码转换成对应的class，
                 c.然后调用newInstance()创建实例
		 */
        Object o = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println(o.getClass().getName());
        Vehicle vehicle = (Vehicle) o;
        vehicle.drive();
        Recharhable recharhable = (Recharhable)o;
        recharhable.recharge();

        ProxyUtils.generateClassFile(ElectricCar.class, "ElectricCarProxy");
    }
}
