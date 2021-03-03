package com.sunyee.javacore.algorithms.backtrace;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by lishunyi on 2021/3/3
 */
public class FullArrange {

    public List<Queue<Integer>> res = new LinkedList<>();

    public List<Queue<Integer>> permute(int[] nums) {
        Queue<Integer> track = new LinkedList<>();
        backTrack(track, nums);
        return res;
    }

    private void backTrack(Queue<Integer> track, int[] nums){
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int num: nums){
            // 排除不合法的选择
            if (track.contains(num))
                continue;
            //做出选择
            track.offer(num);
            //backtrack
            backTrack(track, nums);
            //撤销选择
            track.poll();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new FullArrange().permute(nums).forEach(n->{
            System.out.println(n.toString());
        });
    }
}
