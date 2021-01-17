package com.sunyee.javacore.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 *
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 * 示例 2：
 *
 * 输入：accounts = [[1,5],[7,3],[3,5]]
 * 输出：10
 * 解释：
 * 第 1 位客户的资产总量 = 6
 * 第 2 位客户的资产总量 = 10
 * 第 3 位客户的资产总量 = 8
 * 第 2 位客户是最富有的，资产总量是 10
 * 示例 3：
 *
 * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * 输出：17
 *  
 *
 * 提示：
 *
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/richest-customer-wealth
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by lishunyi on 2021/1/11
 */
public class AccountAsserts {

    public static int maximumWealthWithLambda(int[][] accounts){
        return Arrays.stream(accounts).map(s-> Arrays.stream(s).reduce(0, Integer::sum)).max(Comparator.comparingInt(integer -> integer)).get();
    }

    public static int maximumWealth(int[][] accounts){
        int m = accounts.length;
        int maxinum = 0;
        int current = 0;
        for(int i=0; i < m; i++){
            current = getAccountTotalAsserts(accounts[i]);
            maxinum = compare(current, maxinum);
        }
        return maxinum;
    }

    private static int getAccountTotalAsserts(int[] account){
        int length = account.length;
        int total = 0;
        for (int i = 0; i < length; i++){
            total += account[i];
        }
        return total;
    }

    private static int compare(int current, int maxinum){
        return maxinum >= current ? maxinum : current;
    }

    public static void main(String[] args) {
//        int[][] accounts = {{1,2,3}, {3,2,1}};
//        int[][] accounts = {{1,5}, {7,3}, {3,5}};
        int[][] accounts = {{2,8,7}, {7,1,3}, {1,9,5}};
        System.out.println(maximumWealth(accounts));
        System.out.println(maximumWealthWithLambda(accounts));
    }
}
