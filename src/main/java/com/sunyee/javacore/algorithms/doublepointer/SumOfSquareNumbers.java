package com.sunyee.javacore.algorithms.doublepointer;

/**
 * 题目描述：判断一个数是否为两个数的平方和。
 *
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Created by lishunyi on 2019/5/21
 */
public class SumOfSquareNumbers {
    public static boolean sumOfSuqareNumbers(int target){
        int i = 0, j = (int)Math.sqrt(target);
        while(i <= j){
            int sum = i * i + j * j;
            if (sum == target){
                System.out.println("i: " + i + " j: " + j);
                return true;
            } else if (sum < target){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 8;
        System.out.println(sumOfSuqareNumbers(target));
    }
}
