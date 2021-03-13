package com.sunyee.javacore.algorithms.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个不包含重复数字的数组，要求算法输出这些数字的所有子集
 *
 * 例子:
 * 输入: nums=[1,2]
 * 输出: [[], [1], [2], [1,2]]
 */
public class SubSets {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums){
        //记录走过的路径
        List<Integer> track = new ArrayList<>();
        backTrack(nums, 0, track);
        return res;
    }

    void backTrack(int[] nums, int start, List<Integer> track){
        res.add(new ArrayList<>(track));

        // i从start开始递增
        for (int i=start; i < nums.length; i++){
            //做出选择
            track.add(nums[i]);
            // 回溯进入下一层
            backTrack(nums, i+1, track);
            //撤销选择
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.deepToString(new SubSets().subsets(nums).toArray()));
    }
}
