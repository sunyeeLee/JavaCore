package com.sunyee.javacore.algorithms.bst;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }

    /**
     * 前序遍历打印树
     * @param node
     */
    public static void preOrderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * 后序遍历打印树
     * @param node
     */
    public static void postOrderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.value);
    }

    /**
     * 中序遍历打印树
     * @param node
     */
    public static void inOrderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value);
        inOrderTraversal(node.right);
    }
}
