package com.sunyee.javacore.leetcode.easy;

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
public class Fibonacci2 {

    /**
     * 通过递归的方式求斐波那契数字
     * @param index index
     * @return fibonacci number
     */
    public static int getFibonacciByRecursive(int index){
        if (index < 0){
            throw new RuntimeException("index error!!!");
        } else if (index <= 1){
            return 1;
        }
        return getFibonacciByRecursive(index-1) + getFibonacciByRecursive(index -2);
    }


    /**
     * 通过递推的方式求斐波那契数字
     * @param index
     * @return
     */
    public static int getFibonacciByIterative(int index){
        if(index < 0){
            throw new RuntimeException("index error!!!");
        } else if (index <= 1){
            return 1;
        }
        int current = 0;
        int x = 1;
        int y = 1;
        int z = 1;
        int end = index - 2;
        while (current <= end){
            z = x + y;
            x = y;
            y = z;
            current++;
        }
        return z;
    }


    public static void main(String[] args) {
        System.out.println(getFibonacciByRecursive(0));
        System.out.println(getFibonacciByRecursive(2));
        System.out.println(getFibonacciByRecursive(10));

        System.out.println("***********************");
        System.out.println(getFibonacciByIterative(0));
        System.out.println(getFibonacciByIterative(2));
        System.out.println(getFibonacciByIterative(10));
        System.out.println("***********************");
//        System.out.println(getFibonacciByRecursive(-1));
        System.out.println(getFibonacciByIterative(-1));

    }
}
