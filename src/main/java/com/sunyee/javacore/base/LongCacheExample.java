package com.sunyee.javacore.base;

/**
 * same with Integer
 * Created by lishunyi on 2020/5/8
 */
public class LongCacheExample {
    public static void main(String[] args) {
        Long l1 = 127L;
        Long l2 = 127L;
        Long l3 = new Long(127L);
        System.out.println(l1==l2);
        System.out.println(l1==l3);
    }
}
