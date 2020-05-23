package com.sunyee.javacore.algorithms.dp;

/**
 * 最少钞票数量
 *
 * 凑出某个金额w，求出用到尽量少的钞票数量
 *
 * 如果一个奇葩国家的钞票面额分别是1、5、11, 怎么是的金额为n的钞票数量最少？
 *
 * 1. 定义数组的含义。
 *      当金额为i时，最少的钞票数量为多少？因此我们定义dp[i]为金额i时，最少的钞票数量。所以dp[n]就是我们的答案
 *
 * 2。定义数组元素的之间的关系
 *      当金额为i时，最优钞票数量肯定是从{dp(i-1), dp[i-5], dp[i-11]}中推倒而来。
 *      加入n = 15
 *          取11: cost = f(4) + 1 = 4 + 1 = 5;
 *          取5: cost = f(10) + 1 = 2 + 1 = 3;
 *          取1: cost = f(14) + 1 = 4 + 1 = 5;
 *      因此dp[n] = {dp(n-1), dp[n-5], dp[n-11]} + 1
 *
 * 3. 初始化条件
 *    f(0) = 0
 * Created by lishunyi on 2020/5/21
 */
public class MinimumNumberOfCash {

    public static void getMinNumberOfCash(int n){
        if (n < 1){
            return;
        }
        // 初始化
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i=1; i<= n; i++){
            Integer cost = Integer.MAX_VALUE;
            if (i-1 >=0){
                cost = Math.min(cost, dp[i-1] + 1);
            }
            if (i-5 >= 0){
                cost = Math.min(cost, dp[i-5] + 1);
            }
            if (i - 11 >= 0){
                cost = Math.min(cost, dp[i-11] + 1);
            }
            dp[i] = cost;
            System.out.println("f(" + i + ")=" + cost);
        }
    }

    public static void main(String[] args) {
        getMinNumberOfCash(15);
    }
}
