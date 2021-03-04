package com.sunyee.javacore.algorithms.bst;

/**
 * 计算一棵二叉树共有几个节点
 *
 * 如
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 返回 7
 */
public class CountNode {

    public int count(TreeNode node){
        if (node == null){
            return 0;
        }

        return 1 + count(node.left) + count(node.right);
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
        System.out.println(new CountNode().count(node));
    }
}
