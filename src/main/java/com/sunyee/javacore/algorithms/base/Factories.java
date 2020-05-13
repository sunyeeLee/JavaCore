package com.sunyee.javacore.algorithms.base;

/**
 * Created by lishunyi on 2019/8/16
 */
public class Factories {

    public static void consumerFactory(ServiceFactory serviceFactory){
        Service s = serviceFactory.getService();
        s.method1();
        s.method2();
    }


    public static void main(String[] args) {
        ServiceFactory factory1 = ServiceImplement1.factory;
        ServiceFactory factory2 = ServiceImplement2.factory;
        consumerFactory(factory1);
        consumerFactory(factory2);
    }
}

interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class ServiceImplement1 implements Service{

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServiceImplement1();
        }
    };

    @Override
    public void method1() {
        System.out.println("ServiceImplement1.method1()");
    }

    @Override
    public void method2() {
        System.out.println("ServiceImplement1.method2()");
    }

}


class ServiceImplement2 implements Service{

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServiceImplement2();
        }
    };

    @Override
    public void method1() {
        System.out.println("ServiceImplement2.method1()");
    }

    @Override
    public void method2() {
        System.out.println("ServiceImplement2.method2()");
    }
}
