package com.sunyee.javacore.framework.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lishunyi on 2021/3/18
 */
public class IOCTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("");
        applicationContext.getBean(User.class);
    }
}
