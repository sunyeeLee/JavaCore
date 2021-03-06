package com.sunyee.javacore.algorithms.bst;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 *示例：
 *
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 *

 *      1
 *    /   \
 *   2  -> 3
 *  / \     \
 * 4->5  ->  7
 *  输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，
 * 如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 */
public class FillEachNodeNextII {

    public TreeNode connect(TreeNode root){
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return;
        }
        left.next = right;
        //连接同一个父节点下的两个子节点
        if (left.left != null && left.right != null)
            connectTwoNode(left.left, left.right);
        if (right.left != null && right.right != null)
            connectTwoNode(right.left, right.right);
        //连接不同父节点下的两个子节点
        if (left.right != null && right.left != null)
            connectTwoNode(left.right, right.left);

    }
}
