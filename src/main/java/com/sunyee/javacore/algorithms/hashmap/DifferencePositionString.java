package com.sunyee.javacore.algorithms.hashmap;

/**
 * 第242题. 有效的字母异位词
 *    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例1: s = "apple" t = "elapp"
 *  output: true
 *
 * 示例2: s = "car" t = "art"
 *  output: false


 * 定一个数组叫做record，大小为26 就可以了，初始化为0，因为字符a到字符z的ASCII也是26个连续的数值。
 * 需要把字符映射到数组也就是哈希表的索引下表上，「因为字符a到字符z的ASCII是26个连续的数值，所以字符a映射为下表0，相应的字符z映射为下表25。」
 *
 * 再遍历字符串s的时候，「只需要将 s[i] - ‘a’ 所在的元素做+1 操作即可，并不需要记住字符a的ASCII，只要求出一个相对数值就可以了。」 这样就将字符串s中字符出现的次数，统计出来了。
 *
 * 那看一下如何检查字符串t中是否出现了这些字符，同样在遍历字符串t的时候，对t中出现的字符映射哈希表索引上的数值再做-1的操作。
 *
 * 那么最后检查一下，「record数组如果有的元素不为零0，说明字符串s和t一定是谁多了字符或者谁少了字符，return false。」
 *
 * 最后如果record数组所有元素都为零0，说明字符串s和t是字母异位词，return true。
 *
 * 时间复杂度为O(n)，空间上因为定义是的一个常量大小的辅助数组，所以空间复杂度为O(1)。
 * Created by lishunyi on 2021/2/24
 */
public class DifferencePositionString {


    public static boolean differencePosition(String str1, String str2){
        int[] record = new int[26];
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
            int index = str1Array[i] - 'a';
            record[index] = record[index] + 1;
        }

        for (int i = 0; i < str2.length(); i++) {
            // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
            int index = str2Array[i] - 'a';
            record[index] = record[index] - 1;
        }
        for (int i=0; i<26; i++){
            // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
            if (record[i] != 0){
                return false;
            }
        }
        // record数组所有元素都为零0，说明字符串s和t是字母异位词
        return true;
    }

    public static void main(String[] args) {
        String s = "apple";
        String t = "elapp";
        System.out.println(differencePosition(s, t));
    }
}
