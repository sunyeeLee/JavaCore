package com.sunyee.javacore.algorithms.bst;

/**
 * 第 226 题「翻转二叉树」，输入一个二叉树根节点 root，让你把整棵树镜像翻转，比如输入的二叉树如下：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 算法原地翻转二叉树，使得以 root 为根的树变成：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 思路：
 *  通过观察，我们发现只要把二叉树上的每一个节点的左右子节点进行交换，最后的结果就是完全翻转之后的二叉树。
 */
public class ReverseBST {

    public static TreeNode reverse(TreeNode root){
        // base case
        if (root == null){
            return null;
        }
        /**** 前序遍历位置 ****/
        // root 节点需要交换它的左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 让左右子节点继续翻转它们的子节点
        reverse(root.left);
        reverse(root.right);

        return root;

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

        reverse(node);
        TreeNode.preOrderTraversal(node);
    }
}
