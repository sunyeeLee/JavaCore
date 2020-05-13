package com.sunyee.javacore.designpattern.immutable;

/**
 *
 * 一个类的内部状态创建后，在整个生命期间都不会发生变化时，就是不变类
 * 1。 类为final，确保无子类
 * 2。 属性为private + final，确保不能被访问 和 二次赋值
 * 3。 只有get方法，没有set方法
 *
 * 不变模式不需要同步。
 * Java中不变的模式的案例有：
 * java.lang.String
 * java.lang.Boolean
 * java.lang.Byte
 * java.lang.Character
 * java.lang.Double
 * java.lang.Float
 * java.lang.Integer
 * java.lang.Long
 * java.lang.Short
 * Created by lishunyi on 2019/2/25
 */
public final class People {

    private final String name;

    private final Integer age;

    public People(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public Integer getAge(){
        return this.age;
    }

}
