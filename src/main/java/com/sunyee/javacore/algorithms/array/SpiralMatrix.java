package com.sunyee.javacore.algorithms.array;

import java.util.Arrays;

/**
 * 题目59.螺旋矩阵II
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 * Created by lishunyi on 2021/1/29
 */
public class SpiralMatrix {


    public static int[][] getSpiralMatrix(int n){
        int[][] matrix = new int[n][n];
        int startX = 0;
        int startY = 0;
        int loop = n / 2;   //循环的圈数
        int mid = n / 2;    //最中间的数
        int count = 1;  //每一步数字的自增量
        int offset = 1; //
        int i;
        int j;
        while (loop-- > 0){
            i = startX;
            j = startY;

            // 最上一行的从左到右
            for (j = startY ; j < n + startY - offset; j++){
                matrix[startX][j] = count++;
            }
            // 最右一列从上到下
            for (i = startX; i < n + startX - offset; i++){
                matrix[i][j] = count++;
            }
            // 最下一行从右到左
            for (; j > startY; j--){
                matrix[i][j] = count++;
            }
            // 最做一列从下到上
            for (; i > startX; i--){
                matrix[i][j] = count++;
            }
            // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            startX++;
            startY++;

            // offset 控制每一圈里每一条边遍历的长度
            offset += 2;
        }

        // n为奇数则单独赋值
        if (n % 2 != 0){
            matrix[mid][mid] = count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.deepToString(getSpiralMatrix(n)));
    }
}
