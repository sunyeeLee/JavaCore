package com.sunyee.javacore.algorithms.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 第 797 题「所有可能路径」，函数签名如下：
 *
 * List<List<Integer>> allPathsSourceTarget(int[][] graph);
 * 题目输入一幅有向无环图，这个图包含n个节点，标号为0, 1, 2,..., n - 1，请你计算所有从节点0到节点n - 1的路径。
 *
 * 输入的这个graph其实就是「邻接表」表示的一幅图，graph[i]存储这节点i的所有邻居节点。
 *
 * 比如输入graph = [[1,2],[3],[3],[]]，就代表下面这幅图：
 *  0 -> 1
 *  |    |
 *  2 -> 3
 * Image
 * 算法应该返回[[0,1,3],[0,2,3]]，即0到3的所有路径。
 *
 * 解法很简单，以0为起点遍历图，同时记录遍历过的路径，当遍历到终点时将路径记录下来即可。
 *
 * 既然输入的图是无环的，我们就不需要visited数组辅助了，直接套用图的遍历框架：
 *
 * Created by lishunyi on 2021/3/26
 */
public class AllPossiablePaths {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /**
     * 图遍历框架
     * @param graph 图数组
     * @param s 节点
     * @param path 路径
     */
    public void traverse(int[][] graph, int s, LinkedList<Integer> path){
        // 添加节点s到路径
        path.addLast(s);

        // 判断是否结束
        int n = graph.length;
        if (s == n-1){
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        // 递归遍历相邻节点
        for (int v: graph[s]){
            traverse(graph, v, path);
        }

        // 从路径移出节点s
        path.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        System.out.println(Arrays.deepToString(new List[]{new AllPossiablePaths().allPathsSourceTarget(graph)}));
    }
}
