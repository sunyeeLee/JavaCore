package com.sunyee.javacore.framework.spring.aop;

import com.sunyee.javacore.framework.spring.aop.advice.TicketServiceAfterReturning;
import com.sunyee.javacore.framework.spring.aop.advice.TicketServiceAroundAdvice;
import com.sunyee.javacore.framework.spring.aop.advice.TicketServiceBeforeAdvice;
import com.sunyee.javacore.framework.spring.aop.advice.TicketServiceThrowsAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * Created by lishunyi on 2019/8/1
 */
public class App {

    public static void main(String[] args) {
        Advice beforeAdvice = new TicketServiceBeforeAdvice();
        Advice afterReturningAdvice = new TicketServiceAfterReturning();
        Advice aroundAdvice = new TicketServiceAroundAdvice();
        Advice throwsAdvice = new TicketServiceThrowsAdvice();

        RailwayStation railwayStation = new RailwayStation();

        //2.创建ProxyFactoryBean,用以创建指定对象的Proxy对象
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //3.设置proxy的接口
        proxyFactoryBean.setInterfaces(ITicketService.class);
        //4.设置RealSubject
        proxyFactoryBean.setTarget(railwayStation);
        //5.使用JDK基于接口实现机制的动态代理生成Proxy代理对象，如果想使用CGLIB，需要将这个flag设置成true
<<<<<<< HEAD
        proxyFactoryBean.setProxyTargetClass(false);
=======
        proxyFactoryBean.setProxyTargetClass(true);
>>>>>>> 69e81ebaf5f10d2f02c787dc6e09a6368fd24275

        //6. 添加不同的advice,  各种Advice本质而言是一个方法调用拦截器，
        proxyFactoryBean.addAdvice(afterReturningAdvice);
        proxyFactoryBean.addAdvice(aroundAdvice);
        proxyFactoryBean.addAdvice(beforeAdvice);
        proxyFactoryBean.addAdvice(throwsAdvice);
        ITicketService ticketServiceProxy = (ITicketService) proxyFactoryBean.getObject();
        System.out.println("proxy: " + ticketServiceProxy.getClass());
        ticketServiceProxy.inquire();
<<<<<<< HEAD
        ticketServiceProxy.sell();
=======
>>>>>>> 69e81ebaf5f10d2f02c787dc6e09a6368fd24275
    }
}
