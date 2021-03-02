package com.sunyee.javacore.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    /**
     * 通过递归和剪枝的方式求斐波那契数字。（引入备忘录从而进行剪枝）
     * @return fibonacci number
     */
    public static int getFibonacciByRecursiveAndPrune(int n){

        if (n < 0){
            throw new RuntimeException("index error!!!");
        }
        List<Integer> memo = new ArrayList<>(Collections.nCopies(n+1, 0));
        return helper(memo, n);
    }

    /**
     * 通过动态规划的方式求斐波那契数字。
     * @return fibonacci number
     */
    public static int getFibonacciByDp(int n){
        if (n < 0){
            throw new RuntimeException("index error!!!");
        }
        Integer[] dp = new Integer[n+1];    //保存第n个数字的斐波那契数字
        Arrays.fill(dp,0);
        if (n <= 1){
            return 1;
        }
        //初始化条件
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    private static int helper(List<Integer> memo, int n){
        if (n <= 1){
            return 1;
        }
        if (memo.get(n) != 0){
            return memo.get(n); //已经计算过
        }
        memo.add(n, helper(memo, n-1) + helper(memo, n-2));
        return memo.get(n);
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
        System.out.println(getFibonacciByRecursiveAndPrune(0));
        System.out.println(getFibonacciByRecursiveAndPrune(2));
        System.out.println(getFibonacciByRecursiveAndPrune(10));
        System.out.println("***********************");
        System.out.println(getFibonacciByDp(0));
        System.out.println(getFibonacciByDp(2));
        System.out.println(getFibonacciByDp(10));
    }
}
