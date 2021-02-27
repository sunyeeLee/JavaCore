package com.sunyee.javacore.algorithms.string;

import java.util.Arrays;

/**
 * 题目：剑指Offer 05.替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * Created by lishunyi on 2021/2/26
 */
public class ReplaceSpace {

    public static String replaceSpace(String str){
        int count = 0;
        int oldSize = str.length();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                count++;
            }
        }
        char[] oldArray = str.toCharArray();
        // 扩充数组的大小，也就是每个空格替换成"%20"之后的大小
        char[] newArray = Arrays.copyOf(oldArray, oldArray.length + count * 2);
        for (int i = newArray.length-1, j=oldArray.length-1; j < i; i--, j--){
            if (newArray[j] != ' '){
                newArray[i] = newArray[j];
            } else {
                newArray[i] = '0';
                newArray[i-1] = '2';
                newArray[i-2] = '%';
                i -= 2; //此处需要多减去2
            }
        }
        return new String(newArray);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
