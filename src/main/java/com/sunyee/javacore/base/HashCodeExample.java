package com.sunyee.javacore.base;

/**
 * hashcode example
 * Created by lishunyi on 2020/5/20
 */
public class HashCodeExample {
    public static void main(String[] args) {
        Integer number1 = new Integer(10);
        Integer number2 = new Integer(10);
        System.out.println(number1.hashCode());
        System.out.println(number2.hashCode());
    }
}
