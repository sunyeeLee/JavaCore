package com.sunyee.javacore.algorithms.doublepointer;

/**
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * Created by lishunyi on 2019/5/21
 */
public class Palindrome {

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcba";
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.validPalindrome(s));
    }
}
