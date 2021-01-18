package com.sunyee.javacore.leetcode.easy;

import java.util.Arrays;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by lishunyi on 2021/1/17
 */
public class SumOfOneDimensionalArray {


    public int[] runningSum(int[] nums) {
        int current = 0;
        int[] newNums = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            current += nums[i];
            newNums[i] = current;
        }
        return newNums;
    }

    /**
     * 1.最终答案中，第1个值不用变，第n个值是参数中数组第1到第n个值的和
     * 2. 不用新开一个数组，直接在原数组中操作即可
     * 3. 只用一次遍历，要得到第n个值，只需要用第n-1个值加上第n个值即可
     */
    public int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public void println(int[] nums){
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4};
        int[] arr = {3,1,2,10,1};
        SumOfOneDimensionalArray sumOfOneDimensionalArray = new SumOfOneDimensionalArray();
        sumOfOneDimensionalArray.println(sumOfOneDimensionalArray.runningSum2(arr));
    }
}
