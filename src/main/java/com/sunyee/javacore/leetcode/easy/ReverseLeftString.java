package com.sunyee.javacore.leetcode.easy;


/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLeftString {

    public String reverseLeftWords(String s, int n) {
        return reverseDivideAndConquer(s, n);
    }

    private String reverseByStringAPI(String s, int n){
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    private String reverseByStringAPI2(String s, int n){
        StringBuilder sb = new StringBuilder();
        for (int i=n; i<s.length(); i++){
            sb.append(s.charAt(i));
        }
        for (int i=0; i<n; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private String reverseDivideAndConquer(String s, int n){
        char[] array = s.toCharArray();
        reverseArray(array, 0, n-1);
        reverseArray(array, n, array.length-1);
        reverseArray(array, 0, array.length-1);
        return new String(array);
    }

    private char[] reverseArray(char[] arr, int beginIndex, int endIndex){
        int i = beginIndex;
        int j = endIndex;
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(new ReverseLeftString().reverseLeftWords(s, k));
    }
}
