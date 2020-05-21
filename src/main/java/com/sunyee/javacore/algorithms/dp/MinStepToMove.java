package com.sunyee.javacore.algorithms.dp;

/**
 * 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 举例：
 * 输入:
 * arr = [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 * 1. 定义数组元素的含义
 *      由于我们的目的是从左上角到右下角，最小路径和是多少，那我们就定义 dp[i] [j]的含义为：
 *      当机器人从左上角走到(i, j) 这个位置时，最小的路径和是 dp[i] [j]。那么，dp[m-1] [n-1] 就是我们要的答案了。
 *
 * 2. 找出数组元素之间的关系
 *      当机器人从左上角走到(i, j) 这个位置时，要么是从dp[i-1][j]移动，要么是从dp[i][j-1]移动过来的.
 *      不过这次不是计算所有可能路径，而是计算哪一个路径和是最小的，那么我们要从这两种方式中，
 *      选择一种，使得dp[i] [j] 的值是最小的，
 *      显然有dp[i] [j] = min(dp[i-1][j]，dp[i][j-1]) + arr[i][j];// arr[i][j] 表示网格种的值
 *
 * 3. 找出初始条件
 *      显然，当 dp[i] [j] 中，如果 i 或者 j 有一个为 0，那么还能使用关系式吗？答是不能的，
 *      因为这个时候把 i - 1 或者 j - 1，就变成负数了，数组就会出问题了，所以我们的初始值是计算出
 *      所有的 dp[0] [0….n-1] 和所有的 dp[0….m-1] [0]。这个还是非常容易计算的，
 *      相当于计算机图中的最上面一行和左边一列。因此初始值如下：
 *
 *      dp[0] [j] = arr[0] [j] + dp[0] [j-1]; // 相当于最上面一行，机器人只能一直往右走
 *
 *      dp[i] [0] = arr[i] [0] + dp[i] [0]; // 相当于最左一列，机器人只能一直往下走
 * Created by lishunyi on 2020/5/21
 */
public class MinStepToMove {

    public static int moveByMinStep(int[][] array){
        int m = array.length;
        int n = array[0].length;
        if (m < 1 || n < 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        //初始化
        dp[0][0] = array[0][0];
        //初始化最左边的列
        for (int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + array[i][0];
        }
        //初始化最上面的一行
        for (int i=1; i<n;i++){
            dp[0][i] = dp[0][i-1] + array[0][i];
        }

        // 推到出dp[i][j]
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + array[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] array = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(moveByMinStep(array));
    }

}
