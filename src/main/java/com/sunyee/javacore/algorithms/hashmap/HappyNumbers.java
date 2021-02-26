package com.sunyee.javacore.algorithms.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 第202题. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 「示例：」
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 *
 *
 * 题目中说了会 「无限循环」，那么也就是说「求和的过程中，sum会重复出现，这对解题很重要！」
 *
 * 正如：关于哈希表，你该了解这些！中所说，「当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了。」
 *
 * 所以这道题目使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。
 *
 * 判断sum是否重复出现就可以使用unordered_set。
 *
 * 「还有一个难点就是求和的过程，如果对取数值各个位上的单数操作不熟悉的话，做这道题也会比较艰难。」
 *
 * Created by lishunyi on 2021/2/25
 */
public class HappyNumbers {

    private static int getSumOfEachBit(int number){
        int sumOfEachBit = 0;
        while (number != 0){
            sumOfEachBit += (number % 10) * (number % 10);
            number = number / 10;
        }
        return sumOfEachBit;
    }

    public static boolean checkIsHappyNumber(int number){
        Set<Integer> resultSet = new HashSet<>();
        while (true){
            //无限循环判断
            int sum = getSumOfEachBit(number);
            if (sum == 1){
                return true;
            } else if (resultSet.contains(sum)){
                // 如果这个sum曾经出现过，说明已经陷入了无限循环了，立刻return false
                return false;
            } else {
                resultSet.add(sum);
                number = sum;
            }
        }
    }

    public static void main(String[] args) {
        int number = 19;
        System.out.println(checkIsHappyNumber(number));
    }
}
