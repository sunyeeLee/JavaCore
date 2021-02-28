package com.sunyee.javacore.algorithms.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第15题. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：[ [-1, 0, 1], [-1, -1, 2] ]
 * <p>
 * Created by lishunyi on 2021/2/26
 */
public class ThreeSum {


    /**
     * use double pointer
     * @param nums   array
     * @param target sum
     * @return index
     */
    public static List<Integer[]> solution(int[] nums, int target) {
        List<Integer[]> resultList = new ArrayList<>();
        // sort the arrays
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return resultList;
            }

            // 错误去重方法，将会漏掉-1,-1,2 这种情况
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */

            // 正确去重方法
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    resultList.add(new Integer[]{i, left, right});
                    // 去重
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 找到答案时，双指针同时收缩
                    right--;
                    left++;
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int sum = 0;
        List<Integer[]> result = solution(nums, sum);
        if (result != null) {
            result.forEach(n -> System.out.println(Arrays.toString(n)));
        }
    }
}
