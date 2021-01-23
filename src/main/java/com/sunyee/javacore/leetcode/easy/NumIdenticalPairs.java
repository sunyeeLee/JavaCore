package com.sunyee.javacore.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int numIdenticalPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j]) {
                    numIdenticalPairs += 1;
                }
            }
        }
        return numIdenticalPairs;
    }

    /**
     * By HashMap
     *
     * @param nums 数组
     * @return 好数对个数
     */
    public int numIdenticalPairsByHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int numIdenticalPairs = 0;
        for (int num : nums) {
            int value = map.getOrDefault(num, 0);
            numIdenticalPairs += value;
            map.put(num, value + 1);
        }
        return numIdenticalPairs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        System.out.println(new NumIdenticalPairs().numIdenticalPairsByHashMap(nums));
    }
}
