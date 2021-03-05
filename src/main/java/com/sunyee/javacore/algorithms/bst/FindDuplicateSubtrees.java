package com.sunyee.javacore.algorithms.bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by lishunyi on 2021/3/5
 */
public class FindDuplicateSubtrees {

    // 记录所有子树以及子树出现的次数
    Map<String, Integer> memo = new HashMap<>();

    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode node){
        // 如果该节点没有叶子节点， 则返回 # 号
        if (node == null){
            return "#";
        }

        // 后序遍历
        String left = traverse(node.left);
        String right = traverse(node.right);
        String subTree = left + "," + right + "," + node.value;

        int times = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (times == 1){
            res.add(node);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, times + 1);
        return subTree;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        left.left = new TreeNode(4);
        right.left = new TreeNode(2);
        right.right = new TreeNode(4);
        right.left.left = new TreeNode(4);
        node.left = left;
        node.right = right;
        List<TreeNode> treeNodeList = new FindDuplicateSubtrees().findDuplicateSubtrees(node);
        treeNodeList.forEach(n -> {
            System.out.println("**************");
            TreeNode.preOrderTraversal(n);
        });
    }
}
