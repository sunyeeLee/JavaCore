package com.sunyee.javacore.leetcode.easy;

/**
 * 给定一个整数X（X>0）, 计算X的N次方。
 */
public class PowerProblem {

    public static int IntegerPower(int x, int n){
        if (n == 0){
            return 1;
        }else if (n < 2){
            return x;
        }
        int result = 1;
        for (int i=0; i<n; i++){
            result = result * x;
        }
        return result;
    }

    /**
     * 分治法
     * 1. 如果n为偶数，则结果为: x^(n/2) * x^(n/2)
     * 1. 如果n为奇数，则结果为: x^(n-1/2) * x^(n-1/2) * x
     * @param x
     * @param n
     * @return
     */
    public static int IntegerPowerByDivideAndConquer(int x, int n){
        if (n == 0){
            return 1;
        }else if (n < 2){
            return x;
        }

        if (x % 2 == 0){
            return IntegerPowerByDivideAndConquer(x, n/2) * IntegerPowerByDivideAndConquer(x, n/2);
        } else {
            return IntegerPowerByDivideAndConquer(x, (n-1)/2) * IntegerPowerByDivideAndConquer(x, (n-1)/2) * x;
        }
    }
    public static void main(String[] args) {
        System.out.println(IntegerPowerByDivideAndConquer(2, 3));
    }

}
