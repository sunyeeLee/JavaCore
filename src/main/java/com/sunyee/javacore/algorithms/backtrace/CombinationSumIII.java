package com.sunyee.javacore.algorithms.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第216题.组合总和III
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * Created by lishunyi on 2021/3/3
 */
public class CombinationSumIII {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int n, int k){
        List<Integer> trace = new ArrayList<>();
        backTrace(trace, n, k, 1);
        return res;
    }

    public void backTrace(List<Integer> trace, int target, int k, int start){
        //结束条件
        if (k == 0 && target == 0){
            res.add(new ArrayList<>(trace));
            return;
        }
        // 排除不合法的选择
        if (target < start || k <= 0){
            return;
        }

        //树的遍历
        for (int num = start; num <= 9; num++){
            // 做出选择
            trace.add(num);
            // 向深处遍历
            backTrace(trace, target-num, k-1, num + 1);
            // 撤销选择
            trace.remove(trace.size()-1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(Arrays.deepToString(new CombinationSumIII().combinationSum3(n, k).toArray()));
    }
}
