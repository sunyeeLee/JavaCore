package com.sunyee.javacore.algorithms.dp;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by lishunyi on 2021/3/5
 */
public class RobI {

    private int[] memo; //备忘录，解决重叠子问题

    public int rob(int[] nums){
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp2(nums, 0);
    }

    /**
     * 该方法存在重叠子问题，可以使用备忘录记录子问题
     * @param nums
     * @param houseIndex
     * @return
     */
    public int dp(int[] nums, int houseIndex){
        if (houseIndex >= nums.length){
            return 0;
        }
        int res = Math.max(
                //不抢，去下一家
                dp(nums, houseIndex + 1),
                //抢，然后去下下家
                nums[houseIndex] + dp(nums, houseIndex+2)
        );
        return res;
    }

    public int dp2(int[] nums, int houseIndex){
        if (houseIndex >= nums.length){
            return 0;
        }

        if (memo[houseIndex] != -1){
            return memo[houseIndex];
        }

        int res = Math.max(dp2(nums, houseIndex + 1), nums[houseIndex] + dp2(nums, houseIndex + 2));
        memo[houseIndex] = res;
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new RobI().rob(nums));
    }
}