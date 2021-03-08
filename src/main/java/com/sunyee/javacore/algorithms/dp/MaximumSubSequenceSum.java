package com.sunyee.javacore.algorithms.dp;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *
 解决这个问题需要动态规划技巧，但是dp数组的定义比较特殊。按照我们常规的动态规划思路，一般是这样定义dp数组：

 nums[0..i]中的「最大的子数组和」为dp[i]。

 如果这样定义的话，整个nums数组的「最大子数组和」就是dp[n-1]。如何找状态转移方程呢？按照数学归纳法，假设我们知道了dp[i-1]，如何推导出dp[i]呢？

 如下图，按照我们刚才对dp数组的定义，dp[i] = 5，也就是等于nums[0..i]中的最大子数组和：

        -3 4 -1 2 -1 4
                   i i+1
 那么在上图这种情况中，利用数学归纳法，你能用dp[i]推出dp[i+1]吗？

 实际上是不行的，因为子数组一定是连续的，按照我们当前dp数组定义，并不能保证nums[0..i]中的最大子数组与nums[i+1]是相邻的，也就没办法从dp[i]推导出dp[i+1]。

 所以说我们这样定义dp数组是不正确的，无法得到合适的状态转移方程。

 对于这类子数组问题，我们就要重新定义dp数组的含义：
 以nums[i]为结尾的「最大子数组和」为dp[i]。

 这种定义之下，想得到整个nums数组的「最大子数组和」，不能直接返回dp[n-1]，而需要遍历整个dp数组：

 int res = Integer.MIN_VALUE;
 for (int i = 0; i < n; i++) {
    res = Math.max(res, dp[i]);
 }
 return res;

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by lishunyi on 2021/3/8
 */
public class MaximumSubSequenceSum {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int length = nums.length;
        int[] dp = new int[length];

        //base case
        dp[0] = nums[0];
        for (int i=1; i<length; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }

        for (int result: dp){
            if (result > res){
                res = result;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubSequenceSum().maxSubArray(nums));
    }
}
