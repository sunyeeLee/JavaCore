package com.sunyee.javacore.algorithms.dp;

import com.sunyee.javacore.algorithms.bst.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by lishunyi on 2021/3/5
 */
public class RobIII {

    Map<TreeNode, Integer> memo = new HashMap<>();  //备忘录

    public int rob(TreeNode root) {
        return dp(root);
    }

    public int dp(TreeNode node){
        if (node == null){
            return 0;
        }
        if (memo.containsKey(node)){
            return memo.get(node);
        }

        // 抢，然后去下下家
        int rob = node.value +
                (node.left == null ? 0 : rob(node.left.left) + rob(node.left.right)) +
                (node.right == null ? 0 : rob(node.right.left) + rob(node.right.right));
        // 不抢，然后去下家
        int noRob = rob(node.left) + rob(node.right);

        int res = Math.max(rob, noRob);
        memo.put(node, res);
        return res;
    }

}
