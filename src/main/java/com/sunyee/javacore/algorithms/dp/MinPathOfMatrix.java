package com.sunyee.javacore.algorithms.dp;

/**
 * 【题目】给定一个矩阵 m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
 *          返回所有的路径中最小的路径和。
 * 【举例】如果给定的m如下：
 * arr = [
 *   [1,3,5,9],
 *   [8,1,3,4],
 *   [5,0,6,1],
 *   [8,8,4,0]
 * ]
 *
 *  路径1，3，1，0，6，1，0是所有路径中路径和最小的，所以返回12。
 *
 *
 * 解答如下：
 *
 * 1。定义数组的含义
 *      由于我们的问题是从左上角移动到右下角的最小路径和，因此我们定义当移动到arr[i, j]的时候，
 *      dp[i, j]表示当前位置的最小路径和。因此dp[m, n]就是从左上角移动到右下角的最小路径和了。
 *
 * 2。找出数组元素之间的关系。
 *      因为只能向右或者向下走，并且问题是计算最小路径和。当走到dp[i,j]的时候，要么是从dp[i][j-1]移动而来，要么
 *      是从dp[i-1][j]移动而来。因此我们数组元素之间有以下关系：
 *
 *         dp[i][j] = min{dp[i][j-1], dp[i-1][j-1]} + arr[i][j]
 *
 * 3。找出初始值
 *      当机器人在最上面一行或最左边一列的时候，此时关系不存在。因为数组下标不可能为负数.
 *      所以我们的初始值是计算出所有的 dp[0] [0….n-1] 和所有的 dp[0….m-1] [0]。这个还是非常容易计算的，
 *      相当于计算机图中的最上面一行和左边一列。因此初始值如下：
 *
 *      dp[0] [j] = arr[0] [j] + dp[0] [j-1]; // 相当于最上面一行，机器人只能一直往右走
 *
 *      dp[i] [0] = arr[i] [0] + dp[i-1] [0]; // 相当于最左一列，机器人只能一直往下走
 *
 * Created by lishunyi on 2020/5/25
 */
public class MinPathOfMatrix {

    public static int minPathOfMatrix(int[][] array){
        if (array == null || array.length < 1){
            throw new RuntimeException("array is empty!!!");
        }
        int m = array.length;
        int n = array[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = array[0][0];
        //初始化最左边一列
        for (int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + array[i][0];
        }
        //初始化最上边一行
        for (int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1] + array[0][j];
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + array[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] array = {{1,3,5,9}, {8,1,3,4}, {5,0,6,1}, {8,8,4,0}};
        System.out.println(minPathOfMatrix(array));
    }
}
