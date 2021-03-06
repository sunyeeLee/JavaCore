package com.sunyee.javacore.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。算法的函数签名如下：
 *      // coins 中是可选硬币面值，amount 是目标金额
 *      int coinChange(int[] coins, int amount);
 * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
 *
 * 你认为计算机应该如何解决这个问题？显然，就是把所有可能的凑硬币方法都穷举出来，然后找找看最少需要多少枚硬币。
 *
 * Created by lishunyi on 2021/3/2
 */
public class CoinChange {

    private static Map<Integer, Integer> memo = new HashMap<>();
    /**
     * 动态规划暴力解法
     * @return
     */
    public static int coinChangeByDpWithoutPrune(int[] coins, int amount){
        return dpSubProblemWithMemo(coins, amount);
    }

    private static int dpSubProblem(int[] coins, int amount){
        // base case
        if (amount == 0){
            return 0;
        } else if (amount < 0){
            return -1;
        }
        int minResult = Integer.MAX_VALUE;
        for (int coin: coins){
            int subProblem = dpSubProblem(coins, amount - coin);
            // 子问题无解，跳过
            if (subProblem == -1) continue;
            minResult = Math.min(minResult, 1 + subProblem);
        }
        return minResult != Integer.MAX_VALUE ? minResult : -1;
    }

    private static int dpSubProblemWithMemo(int[] coins, int amount){

        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        // base case
        if (amount == 0){
            return 0;
        } else if (amount < 0){
            return -1;
        }
        int minResult = Integer.MAX_VALUE;
        for (int coin: coins){
            int subProblem = dpSubProblemWithMemo(coins, amount - coin);
            // 子问题无解，跳过
            if (subProblem == -1) continue;
            minResult = Math.min(minResult, 1 + subProblem);
        }
        memo.put(amount, minResult != Integer.MAX_VALUE ? minResult : -1);
        return memo.get(amount);
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChangeByDpWithoutPrune(coins, amount));
    }
}
