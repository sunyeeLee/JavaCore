package com.sunyee.javacore.algorithms.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长子序列
 * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
 *
 * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 *
 * example:
 * Input:
 *      s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 *      "apple"
 * Created by lishunyi on 2019/5/22
 */
public class LongestSubSeries {
    public String findLongestWord(String s, List<String> d){
        String longestWord = "";
        for (String target: d){
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)){
                continue;
            }
            if (isSubSeries(s, target)){
                longestWord = target;
            }
        }
        return longestWord;
    }

    /**
     * 判断target是否字符串s的子序列
     * @param s 原始字符串
     * @param target 待判断的字符串
     * @return true or false
     */
    public boolean isSubSeries(String s, String target){
        int i = 0, j=0;
        while(i < s.length() && j < target.length()){
            if (s.charAt(i) == target.charAt(j)){
                j++;
            }
            i ++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> seriesList = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        LongestSubSeries longestSubSeries = new LongestSubSeries();
        System.out.println(longestSubSeries.findLongestWord(s, seriesList));
    }

}
