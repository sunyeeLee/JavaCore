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

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> solution(int n, int k) {
        backTrace(n, k, 1);
        return res;
    }

    private void backTrace(int n, int k, int u) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = u; i <= n; i ++ ) {
            path.add(i);
            backTrace(n, k - 1, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new NumberArrangeByK().solution(4, 2).toArray()));
    }
}
