package com.sunyee.javacore.algorithms.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111。二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 *
 *     3
 *   /   \
 *  9    20
 *       / \
 *      15  7
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * BFS框架：
 * <p>
 * // 计算从起点 start 到终点 target 的最近距离
 * int BFS(Node start, Node target) {
 * Queue<Node> q; // 核心数据结构
 * Set<Node> visited; // 避免走回头路
 * <p>
 * q.offer(start); // 将起点加入队列
 * visited.add(start);
 * int step = 0; // 记录扩散的步数
 * <p>
 * while (q not empty) {
 * int sz = q.size();
 * 将当前队列中的所有节点向四周扩散
 * for (int i = 0; i < sz; i++) {
 * Node cur = q.poll();
 * 划重点：这里判断是否到达终点
 * if (cur is target)
 * return step;
 * 将 cur 的相邻节点加入队列
 * for (Node x : cur.adj())
 * if (x not in visited) {
 * q.offer(x);
 * visited.add(x);
 * }
 * }
 * 划重点：更新步数在这里
 * step++;
 * }
 * }
 * <p>
 * Created by lishunyi on 2021/3/4
 */
public class MinDepthByBFS {


    public int getMinDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;  //root本身深度就是1
        while (!queue.isEmpty()) {
            int size = queue.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                /* 否则将cur的相邻节点加入队列 */
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            depth++;    //此时深度+1, 表示进入下一层
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
