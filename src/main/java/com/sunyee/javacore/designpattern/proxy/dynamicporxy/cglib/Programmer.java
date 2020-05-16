package com.sunyee.javacore.designpattern.proxy.dynamicporxy.cglib;

/**
 * 真实主题类
 * Created by lishunyi on 2019/7/30
 */
public class Programmer {

    public void code(){
        System.out.println("Life is short, let's coding!!!");
    }

    void codeByDeault(){
        System.out.println("default method");
    }

    protected void codeByProtected(){
        System.out.println("protected method");
    }
}
