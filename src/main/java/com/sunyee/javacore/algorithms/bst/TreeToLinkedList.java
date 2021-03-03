package com.sunyee.javacore.algorithms.bst;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 *      1
 *    /   \
 *   2     5
 *  / \     \
 * 3   4     6
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 *
 * 我们再梳理一下，如何按题目要求把一棵树拉平成一条链表？很简单，以下流程：
 *
 * 1、将 root 的左子树和右子树拉平。
 *
 * 2、将 root 的右子树接到左子树下方，然后将整个左子树作为右子树。
 */
public class TreeToLinkedList {

    public TreeNode flatten(TreeNode root){
        if (root == null) return null;
        transform(root);
        return root;
    }

    public void transform(TreeNode node){
        if (node == null){
            return;
        }
        transform(node.left);
        transform(node.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 2、将左子树作为右子树
        node.left = null;
        node.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.right = new TreeNode(6);
        node.left = left;
        node.right = right;
        new TreeToLinkedList().flatten(node);
        System.out.println(node);
    }
}
