package com.sunyee.javacore.base.initial;

/**
 * 类的初始化顺序
 * Created by lishunyi on 2019/7/23
 */
public class InitialOfClass{
    public static void main(String[] args) {
        new Son();
//        new Son();
    }
}

class Son extends Father{
    static{
        System.out.println("子类静态代码块");
    }

    public static IntegerHolder holder = new IntegerHolder("子类静态成员");

    public IntegerHolder holder1 = new IntegerHolder("子类成员变量");

    public Son(){
        System.out.println("子类构造函数");
    }
}

class Father{

    static{
        System.out.println("父类静态代码块");
    }

    public static IntegerHolder holder = new IntegerHolder("父类静态成员");

    public IntegerHolder holder1 = new IntegerHolder("父类成员变量");

    public Father(){
        System.out.println("父类构造函数");
    }
}

class IntegerHolder{

    private String value;

    public IntegerHolder(String value){
        this.value = value;
        System.out.println(getValue());
    }

    public String getValue(){
        return this.value;
    }
}