package com.sunyee.javacore.base;

/**
 * Created by lishunyi on 2019/7/31
 */
public class StringExample {
    public static void main(String[] args) {
        String s1 = "li";
        String s2 = "li";
        String s3 = new String("li");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());

    }
}
