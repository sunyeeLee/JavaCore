package com.sunyee.javacore.algorithms.array;

/**
 * 题目209.长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * Created by lishunyi on 2021/1/28
 */
public class MinLengthOfSubArray {

    /**
     * for循环暴力解题。 O(n^2)
     *
     * @param array  input array
     * @param target sum
     * @return
     */
    public static int minLengthOfSubArrayByForLoop(int[] array, int target) {
        int result = Integer.MAX_VALUE;
        int subArrayLength = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum >= target) {
                    subArrayLength = j - i + 1;
                    result = result < subArrayLength ? result : subArrayLength;
                    break;
                }
                subArrayLength++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    /**
     * 使用双指针构建一个滑动窗口
     *
     * @return
     */
    public static int minLengthOfSubArrayBySlideWindow(int[] array, int target) {
        int left = 0;
        int result = Integer.MAX_VALUE;
        int subLength = 0;
        int sum = 0;
        for (int right = 0; right < array.length; right++) {
            sum += array[right];
            while (sum >= target){
                subLength = (right - left) + 1;
                result = result < subLength ? result : subLength;
                sum -= array[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0: result;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minLengthOfSubArrayBySlideWindow(array, target));
    }
}
