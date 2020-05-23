package com.sunyee.javacore.algorithms.dp;

/**
 * 最长递增子序列
 * 最长上升子序列（LIS）问题：给定长度为n的序列a，从a中抽取出一个子序列，这个子序列需要单调递增。问最长的上升子序列（LIS）的长度。
 * 　　e.g. 1,5,3,4,6,9,7,8的LIS为1,3,4,6,7,8，长度为6。
 *
 * 1. 定义数组含义： 我们的问题是求序列中最长的子序列。那我们就定义dp[i]： 当为Ai数字为结尾时，此时的序列长度最长。（Ai为数组中第i个元素）。
 *                  所有dp[n]即为最长子序列的长度.
 *
 * 2. 数组元素之间的关系：
 *      考虑比x小的每一个p：如果 Ax > Ap ，那么f(x)可以取f(p)+1
 *      解释：我们把 [公式] 接在 [公式] 的后面，肯定能构造一个以 [公式] 结尾的上升子序列，长度比以 [公式] 结尾的LIS大1
 *        f(x) = max{f(p) + 1}, 其中p < x。
 *        即dp[n] = max{dp[i] + 1}, 其中n < i
 *
 * 3. 初始条件：
 *      dp数组的元素初始化为1。
 * Created by lishunyi on 2020/5/21
 */
public class LongestIncreaseSequence {

    public static void getLongestIncreaseSequence(int[] arrrays){
        if (arrrays.length <=1){
            return;
        }
        //初始化条件
        int longest = 0;
        int m = arrrays.length;
        int[] dp = new int[m];
        for (int i=0; i< m; i++){
            dp[i] = 1;
        }

        for (int x=0; x<arrrays.length;x++){
            for (int p=0; p<x; p++){
                if (arrrays[p] < arrrays[x]){
                    dp[x] = Math.max(dp[x], dp[p]+1);
                }
            }
            System.out.println("dp[" + x +"]=" + dp[x]);
        }

        for (int i=0; i< arrrays.length; i++){
            longest = Math.max(longest, dp[i]);
        }

        System.out.println("longest: " + longest);
    }

    public static void main(String[] args) {
        int[] arrays = {1, 5, 3, 4, 6, 9, 7, 8};
        getLongestIncreaseSequence(arrays);
    }
}
