package com.sunyee.javacore.algorithms.bst;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by lishunyi on 2021/3/5
 */
public class MinimumDifferenceNode {

    private int minimumDifference = Integer.MAX_VALUE;
    private TreeNode preNode;

    public int getMinimumDifference(TreeNode root) {
        traverseAndGetMin(root);
        return minimumDifference;
    }

    public void traverseAndGetMin(TreeNode node){
        if (node == null){
            return;
        }

        // 中序遍历
        traverseAndGetMin(node.left);
        if (preNode != null){
            int curValue = node.value;
            minimumDifference = Math.min(Math.abs((preNode.value - curValue)), minimumDifference);
        }
        preNode = node;
        traverseAndGetMin(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(new MinimumDifferenceNode().getMinimumDifference(root));
    }
}
