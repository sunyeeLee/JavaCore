package com.sunyee.javacore.leetcode;

/**
 * 斐波那契数列
 * 1, 1, 2, 3, 5, 8......
 *
 * 输入index n，输出第n位数字
 * input: 1
 * output: 1
 *
 * input: 2
 * output: 2
 *
 * Created by lishunyi on 2019/9/26
 */
public class Fibonacci {

    /**
     * 通过递归的方式求斐波那契数字
     * @param index index
     * @return fibonacci number
     */
    public static int getFibonacciNumberByRecursive(int index){
        if (index < 0){
            throw new RuntimeException("index error!!!index: " + index);
        } else if (index <= 1){
            return 1;
        }
        return getFibonacciNumberByRecursive(index-1) + getFibonacciNumberByRecursive(index-2);
    }


    public static int getFibonacciNumberByIterative(int index){
        if (index < 0){
            throw new RuntimeException("index error!!!index: " + index);
        } else if (index <= 1){
            return 1;
        }
        int current = 0;
        int x = 1;
        int y = 1;
        int z = 1;
        int end = index - 2;
        while(current <= end){
            z = x + y;
            x = y;
            y = z;
            current += 1;
        }
        return z;
    }

    public static void main(String[] args) {
        System.out.println(getFibonacciNumberByRecursive(0));
        System.out.println(getFibonacciNumberByRecursive(1));
        System.out.println(getFibonacciNumberByRecursive(10));

        System.out.println("****************************");
        System.out.println(getFibonacciNumberByIterative(0));
        System.out.println(getFibonacciNumberByIterative(1));
        System.out.println(getFibonacciNumberByIterative(10));
    }
}
