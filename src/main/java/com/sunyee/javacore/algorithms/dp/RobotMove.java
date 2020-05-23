package com.sunyee.javacore.algorithms.dp;

/**
 * 问题描述
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 1. 定义数组元素的含义
 *      由于我们的目的是从左上角到右下角一共有多少种路径，那我们就定义 dp[i] [j]的含义为：当机器人从左上角走到(i, j)
 *      这个位置时，一共有 dp[i] [j] 种路径。那么，dp[m-1] [n-1] 就是我们要的答案了。
 *
 *      注意，这个网格相当于一个二维数组，数组是从下标为 0 开始算起的，所以 右下角的位置是 (m-1, n - 1)，
 *      所以 dp[m-1] [n-1] 就是我们要找的答案。
 *
 * 2。 找出关系数组元素之间的关系式
 *      想象以下，机器人要怎么样才能到达 (i, j) 这个位置？由于机器人可以向下走或者向右走，所以有两种方式到达
 *
 *      一种是从 (i-1, j) 这个位置走一步到达
 *      一种是从(i, j - 1) 这个位置走一步到达
 *
 *      因为是计算所有可能的步骤，所以是把所有可能走的路径都加起来，
 *      所以关系式是 dp[i] [j] = dp[i-1] [j] + dp[i] [j-1]。
 *
 * 3。 找出初始值
 *      当 dp[i] [j] 中，如果 i 或者 j 有一个为 0，那么还能使用关系式吗？答是不能的，因为这个时候
 *      把 i - 1 或者 j - 1，就变成负数了，数组就会出问题了，所以我们的初始值是计算出所有的 dp[0] [0….n-1]
 *      和所有的 dp[0….m-1] [0]。这个还是非常容易计算的，相当于计算机图中的最上面一行和左边一列。因此初始值如下：
 *
 *      dp[0] [0….n-1] = 1; // 相当于最上面一行，机器人只能一直往左走
 *      dp[0…m-1] [0] = 1; // 相当于最左面一列，机器人只能一直往下走
 * Created by lishunyi on 2020/5/20
 */
public class RobotMove {

    public static int pathsOfRobotMove(int m, int n){
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n]; //
        // 初始化
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        // 推导出 dp[m-1][n-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(pathsOfRobotMove(3, 0));
    }
}
