package com.sunyee.javacore.algorithms.doublepointer;

/**
 * 题目描述： 判断字符串是否为回文串
 * Input: "aba"
 * Output: True
 * Created by lishunyi on 2019/5/21
 */
public class IsPalindrome {
    public Boolean isPalindrome(String s){
        for (int i=0, j=s.length()-1; i<j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcacba";
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(s));
    }
}
