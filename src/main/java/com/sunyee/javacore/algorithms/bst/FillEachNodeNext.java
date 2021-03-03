package com.sunyee.javacore.algorithms.bst;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
 *  / \   / \
 * 4->5->6->7
 *  输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，
 * 如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FillEachNodeNext {
    public TreeNode connect(TreeNode node){
        if (node == null) return null;
        connectTwoNode(node.left, node.right);
        return  node;
    }

    public void connectTwoNode(TreeNode left, TreeNode right){
        if (left == null || right == null){
            return;
        }
        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        left.next = right;

        // 连接相同父节点的两个子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        // 连接跨越父节点的两个子节点
        //左子树的右结点连接右子树的左结点
        connectTwoNode(left.right, right.left);
    }
}
