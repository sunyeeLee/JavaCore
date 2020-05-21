package com.sunyee.javacore.algorithms.dp;

/**
 * 问题描述：
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *  1. 定义问题边界： 我们的问题是要求青蛙跳上 n 级的台阶总共由多少种跳法，那我们就定义 dp[i] 的含义为：
 *                  跳上一个 i 级的台阶总共有 dp[i] 种跳法。这样，如果我们能够算出 dp[n]
 *  2. 找出数组元素间的关系式：
 *              把一个规模比较大的问题分成几个规模比较小的问题，然后由小的问题推导出大的问题。
 *              也就是说，dp[n] 的规模为 n，比它规模小的是 n-1, n-2, n-3.... 也就是说，
 *              dp[n] 一定会和 dp[n-1], dp[n-2]....存在某种关系的。我们要找出他们的关系。
 *
 *              所以青蛙到达第 n 级的台阶有两种方式：
 *
 *                  一种是从第 n-1 级跳上来
 *
 *                  一种是从第 n-2 级跳上来
 *
 *                  由于我们是要算所有可能的跳法的，所以有 dp[n] = dp[n-1] + dp[n-2]。
 *  3. 初始条件： n = 1, 1  ->{1}
 *              n = 2， 2 ->{1, 2}
 *              n = 3, 3 ->{3次1级， 1次1级1次2级， 1次2级1次1级}
 *
 *  动态规划一般方法有 递推和递归 2种方法。
 * Created by lishunyi on 2020/5/20
 */
public class FrogJumping {

    public static int jump(int n){
        if (n <= 1){
            return n;
        }
        //保存历史数据的数组
        int[] dp = new int[n+1];
        //定义初始条件
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(jump(3));
        System.out.println(jump(4));
        System.out.println(jump(5));
    }
}
