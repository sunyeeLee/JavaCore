package com.sunyee.javacore.base;

/**
 * 父子变量同名问题
 * Created by lishunyi on 2019/4/11
 */
public class SameVariableProblem {
    public static void main(String[] args) {
        Parent sub = new Sub();
        Sub sub1 = new Sub();
        System.out.println(sub.i + sub1.i);
    }
}

class Parent{
    int i = 10;
}

class Sub extends Parent{
    int i = 30;
}