package com.sunyee.javacore.base;

/**
 * Created by lishunyi on 2020/4/8
 */
public class StringByInfiniteRecursion {

    public String toString(){

        //自动类型转换错误，this转换为String类型调用toString(), 导致递归调用。应该将this改为super.toString()
//        return "StringByInfiniteRecursion address" + this;
        return "StringByInfiniteRecursion address: " + super.toString();
    }

    public static void main(String[] args) {
        StringByInfiniteRecursion stringByInfiniteRecursion = new StringByInfiniteRecursion();
        System.out.println(stringByInfiniteRecursion);
    }
}
