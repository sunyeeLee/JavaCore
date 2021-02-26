package com.sunyee.javacore.algorithms.string;

/**
 * 题目：541. 反转字符串II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 *
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * Created by lishunyi on 2021/2/26
 */
public class ReverseStringWithK {

    private static void reverse(char[] s, int start, int end) {
        int offset = (end - start + 1) / 2;
        for (int i = start, j = end; i < start + offset; i++, j--) {
            swap(s, i , j);
        }
    }

    private static void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static String reverseStringWithK(String s, int k) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i += (2 * k)) {
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
        if (i + k <= chars.length) {
            reverse(chars, i, i + k - 1);
            continue;
        }
        // 3. 剩余字符少于 k 个，则将剩余字符全部反转。
        reverse(chars, i, chars.length - 1);
    }
    return new String(chars);
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 3;
        System.out.println(reverseStringWithK(str, k));
    }
}
