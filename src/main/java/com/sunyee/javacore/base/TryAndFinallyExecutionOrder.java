package com.sunyee.javacore.base;

import java.util.Arrays;

/**
 * try() ⾥⾯有⼀个return语句， 那么后⾯的finally{}⾥⾯的code会不会被执⾏， 什么时候执⾏， 是在return前还是return后?
 *
 * 如果try中有return语句， 那么finally中的代码还是会执⾏。因为return表⽰的是要整个⽅法体返回， 所以，finally中的语句会在return之前执⾏。
 *
 * 但是return前执行的finally块内，对数据的修改效果对于引用类型和值类型会不同
 * Created by lishunyi on 2020/4/23
 */
public class TryAndFinallyExecutionOrder {

    static int value(){
        int i =0;
        try{
            return i;
        } finally {
            System.out.println("finally block!!!");
            i = i + 2;
        }
    }

    static int value1(){
        int i =0;
        try{
            return i;
        } finally {
            System.out.println("finally block!!!");
            return i + 2;
        }
    }

    static int[] reference(){
        int[] a = new int[2];
        try{
            return a;
        } finally {
            a[0] = 2;
            System.out.println("finally block!!!");
        }
    }

    public static void main(String[] args) {
        System.out.println(value());
        System.out.println(value1());
        System.out.println(Arrays.toString(reference()));
    }
}
