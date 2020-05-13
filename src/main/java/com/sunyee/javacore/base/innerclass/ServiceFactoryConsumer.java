package com.sunyee.javacore.base.innerclass;

/**
 * Created by lishunyi on 2020/4/2
 */
public class ServiceFactoryConsumer {

    public static void serviceConsumer(ServiceFactory serviceFacotry){
        Service service = serviceFacotry.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        ServiceFactory factory1 = Implementation1.serviceFacotry;
        ServiceFactory factory2 = Implementation2.serviceFacotry;
        serviceConsumer(factory1);
        serviceConsumer(factory2);
    }
}

class Implementation1 implements Service{

    private Implementation1(){}
    @Override
    public void method1() {
        System.out.println("Implementation1 method1()");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2()");
    }

    public static ServiceFactory serviceFacotry = new ServiceFactory(){
        public Service getService(){
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service{

    private Implementation2(){}
    @Override
    public void method1() {
        System.out.println("Implementation2 method1()");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2()");
    }

    public static ServiceFactory serviceFacotry = new ServiceFactory(){
        public Service getService(){
            return new Implementation2();
        }
    };
}

interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}