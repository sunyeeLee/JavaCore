package com.sunyee.javacore.algorithms.dp;

import java.util.Arrays;

/**
 * 最长公共子序列
 *
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子序列。
 *
 * 【举例】
 *      str1=＂1A2C3D4B56＂,str2=＂B1D23CA45B6A＂.
 *      
 *      ＂123456＂或者＂12C4B6＂都是最长公共子序列，返回哪一个都行。
 *
 *
 *
 * 1. 定义数组含义
 *      我们的要求是找出两个字符串的最长公共子序列。那我们就定义dp[i][j]的含义为：
 *      在（i, j）位置，dp[i][j]表示两个字符串之间的最长公共子序列。
 *
 * 2. 数组元素之间的关系
 *      如果word[i] == word[j]的话，代表当前位置字符相等，长度需要  +1;
 *      那么dp[i][j]的推导有2中情况：
 *       1. word[i] ！= word[j]， dp[i][j] = max{dp[i-1][j], dp[i][j-1]}
 *       2. word[i] == word[j],   dp[i][j] = max{dp[i-1][j], dp[i][j-1]} + 1
 *
 * 3. 找出初始条件
 *      矩阵dp第一列即dp[0..M-1][0]，dp[i][0]的含义是str1[0..i]与str2[0]的最长公共子序列长度。
 *      str2[0]只有一个字符，所以dp[i][0]最大为1。如果str1[i]==str2[0]，令dp[i][0]=1，一旦dp[i][0]被设置为 1，
 *      之后的 dp[i+1..M-1][0]也都为 1。比如，str1[0..M-1]=＂ABCDE＂，str2[0]=＂B＂。str1[0]为＂A＂，
 *      与str2[0]不相等，所以dp[0][0]=0。str1[1]为＂B＂，与str2[0]相等，所以str1[0..1]与str2[0]的最长公共子序列为＂B＂，
 *      令 dp[1][0]=1。之后的 dp[2..4][0]肯定都是 1，因为 str[0..2]、str[0..3]和str[0..4]与str2[0]的最长公共子序列肯定有＂B＂。
 *
 *      2.矩阵dp第一行即dp[0][0..N-1]与步骤1同理，如果str1[0]==str2[j]，则令dp[0][j]=1，一旦dp[0][j]被设置为1，之后的dp[0][j+1..N-1]也都为1。
 *
 */
public class LongestCommonSequence {

    public static int[][] getDp(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        if (word1.charAt(0) == word2.charAt(0)){
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }

        for (int i=1; i<m; i++){
            if (word1.charAt(i) == word2.charAt(0)){
                dp[i][0] = Math.max(dp[i-1][0], 1);
            } else {
                dp[i][0] = Math.max(dp[i-1][0], 0);
            }
        }

        for (int j=1; j<n; j++){
            if (word2.charAt(j) == word1.charAt(0)){
                dp[0][j] = Math.max(dp[0][j-1], 1);
            } else {
                dp[0][j] = Math.max(dp[0][j-1], 0);
            }
        }

        for (int i =1; i< word1.length(); i++){
            for (int j=1; j< word2.length(); j++){
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        String str1="1A2C3D4B56";
        String str2="B1D23CA45B6A";
        int[][] dp = getDp(str1, str2);
        System.out.println(Arrays.deepToString(dp));
    }
}
