package com.sunyee.javacore.algorithms.string;

/**
 * 题目：344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"] 输出：["o","l","l","e","h"] 示例 2：
 *
 * 输入：["H","a","n","n","a","h"] 输出：["h","a","n","n","a","H"]
 *
 * Created by lishunyi on 2021/2/26
 */
public class ReverseString {

    public static String reverse(String str){
        char[] charArray = str.toCharArray();
        for (int i=0, j=charArray.length-1; i< (charArray.length/2); i++, j--){
            swap(charArray, i , j);
        }
        return new String(charArray);
    }

    private static void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverse(s));
    }
}
