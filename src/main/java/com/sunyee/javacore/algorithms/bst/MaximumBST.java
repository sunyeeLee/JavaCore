package com.sunyee.javacore.algorithms.bst;


/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 *  
 *
 * 示例 1：
 *       6
 *    /    \
 *   3      5
 *    \    /
 *    2   0
 *     \
 *      1
 *
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 *         - 空数组，无子节点。
 *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 *             - 空数组，无子节点。
 *             - 只有一个元素，所以子节点是一个值为 1 的节点。
 *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 *         - 只有一个元素，所以子节点是一个值为 0 的节点。
 *         - 空数组，无子节点。
 * 示例 2：
 *
 *
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by lishunyi on 2021/3/4
 */
public class MaximumBST {

    public TreeNode constructMaximumBinaryTree(int[] nums){
        return build(nums, 0, nums.length-1);
    }
    public TreeNode build(int[] nums, int from, int to){

        // base case
        if (from > to) {
            return null;
        }

        //找到最大值
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for (int i = from ; i <= to; i++){
            if (nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);
        // 构建当前最大值左边的子树
        root.left = build(nums, from, index-1);
        // 构建当前最大值右边的子树
        root.right = build(nums, index + 1, to);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode node = new MaximumBST().constructMaximumBinaryTree(nums);
        TreeNode.preOrderTraversal(node);
    }
}
