package com.sunyee.javacore.algorithms.bst;

/**
 * 求一棵二叉树的最大值
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 */
public class MaxValueInTree {
    int maxValue(TreeNode root){
        if (root == null){
            return -1;
        }
        //后序遍历
        int left = maxValue(root.left);
        int right = maxValue(root.right);
        return Math.max(Math.max(left, right), root.value);
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);
        node.left = left;
        node.right = right;
        System.out.println(new MaxValueInTree().maxValue(node));
    }
}
