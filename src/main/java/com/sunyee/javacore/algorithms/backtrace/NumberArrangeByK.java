package com.sunyee.javacore.algorithms.backtrace;

import java.util.*;

/**
 * 第77题. 组合
 * 题目链接：https://leetcode-cn.com/problems/combinations/
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * Created by lishunyi on 2021/3/3
 */
public class NumberArrangeByK {

    public List<Set<Integer>> res = new ArrayList<>();

    public List<Set<Integer>> solution(int n, int k) {
        Set<Integer> trace = new HashSet<>();
        backTrace(trace, n, k, 1);
        return res;
    }

    private void backTrace(Set<Integer> trace, int n, int k, int start) {
        //结束条件
        if (trace.size() == k) {
            res.add(new HashSet<>(trace));
            return;
        }

        for (int num = start; num <= n ; num ++){
            // 过滤非法条件
            if (trace.contains(num)){
                continue;
            }

            //做出选择
            trace.add(num);
            //进入下一步选择
            backTrace(trace, n, k, start+1);
            // 撤销选择
            trace.remove(num);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new NumberArrangeByK().solution(4, 2).toArray()));
    }
}
