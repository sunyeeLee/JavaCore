package com.sunyee.javacore.algorithms.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 第1题. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 「示例:」
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * Created by lishunyi on 2021/2/25
 */
public class SumOfTwoNumbers {

    public static int[] solution(int[] arrays, int sum){
        int[] result = null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0 ; index < arrays.length; index++){
            int target = sum - arrays[index];
            int current = arrays[index];
            if (!map.containsKey(current)){
                map.put(target, index);
            } else {
                // 找到目标, 返回下标
                result = new int[]{map.get(current), index};
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution(nums, target)));
    }
}
