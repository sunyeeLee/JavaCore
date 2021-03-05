package com.sunyee.javacore.algorithms.bst;

/**
 * 106. 从中序与后序遍历序列构造二叉树

 根据一棵树的中序遍历与后序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 中序遍历 inorder = [9,3,15,20,7]
 后序遍历 postorder = [9,15,7,20,3]
 返回如下的二叉树：
   3
  / \
 9  20
   /  \
  15   7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * Created by lishunyi on 2021/3/4
 */
public class BuildTreeByInorderAndPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder){
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd){
        if (inStart > inEnd){
            return null;
        }
        // 根节点为后序遍历数组中的最后一个元素
        int rootValue = postorder[postEnd];
        // 找到rootValue在中序遍历数组的位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++){
            if (rootValue == inorder[i]){
                index = i;
                break;
            }
        }
        //左子树节点个数
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder, inStart, index-1,postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index+1, inEnd, postorder, postStart + leftSize, postEnd-1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode tree = new BuildTreeByInorderAndPostorder().buildTree(inorder, postorder);
        TreeNode.preOrderTraversal(tree);
    }
}
