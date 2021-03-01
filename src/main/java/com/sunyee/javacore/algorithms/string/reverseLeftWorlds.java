package com.sunyee.javacore.algorithms.string;

/**
 *
 * 题目：剑指Offer58-II.左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *   限制：
 * 1 <= k < s.length <= 10000
 *
 * Created by lishunyi on 2021/2/27
 */
public class reverseLeftWorlds {

    public static String reverseLeftString(String str, int k){
        char[] array = str.toCharArray();
        // 翻转[0,k)区间的字符串
        reverse(array, 0, k-1);
        // 翻转[k,n)区间的字符串
        reverse(array, k, array.length-1);
        // 翻转[0,n)区间的字符串
        reverse(array, 0, array.length-1);
        return new String(array);
    }

    private static char[] reverse(char[] charArray, int start, int end){
        for (int i=start, j=end; i< j; i++, j--){
            swap(charArray, i , j);
        }
        return charArray;
    }

    private static void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseLeftString(s, k));
    }
}
