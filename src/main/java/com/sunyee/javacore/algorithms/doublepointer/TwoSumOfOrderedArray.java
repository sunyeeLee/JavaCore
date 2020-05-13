package com.sunyee.javacore.algorithms.doublepointer;

import java.util.Arrays;

/**
 * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 *
 * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 *
 *          如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 *          如果 sum > target，移动较大的元素，使 sum 变小一些；
 *          如果 sum < target，移动较小的元素，使 sum 变大一些。
 *
 * Example:
 *         Input: numbers={2, 7, 11, 15}, target=9
 *         Output: index1=1, index2=2
 * Created by lishunyi on 2019/5/21
 */
public class TwoSumOfOrderedArray {
    public static int[] twoSum(int[] orderedArray, int target){
        int i = 0, j = orderedArray.length - 1;
        while (i < j){
            int sum = orderedArray[i] + orderedArray[j];
            if (sum == target){
                return new int[]{i + 1, j + 1};
            } else if (sum < target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] orderArray = {1, 2, 7, 9, 10};
        int target = 9;
        int[] location = twoSum(orderArray, target);
        System.out.println(Arrays.toString(location));
    }
}
