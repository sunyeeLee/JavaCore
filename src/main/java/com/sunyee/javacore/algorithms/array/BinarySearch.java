package com.sunyee.javacore.algorithms.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * Created by lishunyi on 2021/1/27
 */
public class BinarySearch {

    /**
     * 暴力解法
     * O(n)
     * @return
     */
    public static int search(int[] array, int target){
        if (array == null){
            throw new RuntimeException("illegal input");
        }
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                return array[i];
            }
        }
        return array.length;
    }

    /**
     * 二分法解法1
     * 需要明确区间。
     *          // 分别处理如下四种情况
     *         // 目标值在数组所有元素之前 [0,0)
     *         // 目标值等于数组中某一个元素 return middle
     *         // 目标值插入数组中的位置 [left, right) ，return right 即可
     *         // 目标值在数组所有元素之后的情况 [left, right)，return right 即可
     * @return
     */
    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length; // 定义target在左闭右开的区间里，[left, right)  target
        while (left < right){ // 因为left == right的时候，在[left, right)是无效的空间
            int middle = left + ((right - left) >> 1);
            if (array[middle] > target){
                right = middle; // target 在左区间，在[left, middle)中
            } else if (array[middle] < target){
                left = middle + 1; // target 在右区间，在 [middle+1, right)中
            } else {
                return middle; // 数组中找到目标值的情况，直接返回下标
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前 [0,0)
        // 目标值等于数组中某一个元素 return middle
        // 目标值插入数组中的位置 [left, right) ，return right 即可
        // 目标值在数组所有元素之后的情况 [left, right)，return right 即可
        return right;
    }

    /**
     * 二分法解法2
     * 需要明确区间。
     *          // 分别处理如下四种情况
     *         // 目标值在数组所有元素之前 [0,0)
     *         // 目标值等于数组中某一个元素 return middle
     *         // 目标值插入数组中的位置 [left, right) ，return right 即可
     *         // 目标值在数组所有元素之后的情况 [left, right)，return right 即可
     * @return
     */
    public static int binarySearch2(int[] array, int target){
        int left = 0;
        int right = array.length - 1; // 定义target在左闭右闭的区间里，[left, right]  target
        while (left <= right){
            int middle = left + ((right - left) >> 1);
            if (array[middle] > target){
                right = middle - 1; // target 在左区间，在[left, middle-1]中
            } else if (array[middle] < target){
                left = middle + 1; // target 在右区间，在 [middle+1, right]中
            } else {
                return middle; // 数组中找到目标值的情况，直接返回下标
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前 [0,-1)
        // 目标值等于数组中某一个元素 return middle
        // 目标值插入数组中的位置 [left, right] ，return right + 1 即可
        // 目标值在数组所有元素之后的情况 [left, right]，return right + 1 即可
        return right + 1;
    }
}
