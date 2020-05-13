package com.sunyee.javacore.designpattern.singleton;

/**
 * Created by lishunyi on 2019/8/19
 */
public enum  SingletonByEnum {
    INSTANCE;

    SingletonByEnum(){
        System.out.println("SingletonByEnum is created!");
    }

    public static void main(String[] args) {
        SingletonByEnum singletonByEnum = SingletonByEnum.INSTANCE;
        SingletonByEnum singletonByEnum1 = SingletonByEnum.INSTANCE;
        System.out.println(singletonByEnum == singletonByEnum1);
    }
}
