package com.sunyee.javacore.algorithms.doublepointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 *  反转字符串中的元音字符
 * Example:
 *          Given s = "leetcode", return "leotcede".
 * Created by lishunyi on 2019/5/21
 */
public class ReverseVowelsOfString {

    private static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    /**
     * 使用双指针指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历。
     */
    public static String reverseVowelsOfString(String s){
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while(i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)){
                result[i++] = ci;
            } else if (!vowels.contains(cj)){
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowelsOfString(s));
    }
}
