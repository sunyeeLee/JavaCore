package com.sunyee.javacore.algorithms;

/**
 *
 * 给定⼀一个⾮非空字符串串 s 和⼀一个缩写 abbr，请校验它们是否匹配。
 * 假设字符串串中只包含⼩小写字⺟母，缩写中只包含⼩小写字⺟母和数字。缩写中的数字
 * 表示其缩略略的字符数;连续多位数字表示⼀一个多位数。
 * 例例如，字符串串 “word” 的缩写有且仅有以下这些:[“word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", “4"]。
 * 例例 1:输⼊入:s = “internationalization"，abbr = "i12iz4n" 返回:true
 * 解释:abbr 中的 12 表示有⼗十⼆二个字符被缩略略了了。 例例 2:输⼊入:s = “apple"，abbr = “a2e"
 * 返回:false
 * 需要实现的⽅方法原型:boolean valid(String word, String abbr)
 * Created by lishunyi on 2020/5/18
 */
public class StringValid {

    public static boolean valid(String word, String abbr){
        if ((word == null || "".equals(word) || (abbr == null || "".equals(abbr)))){
            return false;
        }
        int wordLength = word.length();
        int abbrLength = abbr.length();
        int i = 0;
        int j = 0;
        while(i < wordLength && j < abbrLength){
            if (Character.isDigit(abbr.charAt(j))){
                if (abbr.charAt(j) == '0'){
                    return false;
                }
                int numMoved = 0;
                while (j<abbrLength && Character.isDigit(abbr.charAt(j))){
                    numMoved = numMoved * 10 + Integer.valueOf(String.valueOf(abbr.charAt(j)));
                    j++;
                }
                i+=numMoved;
            } else {
                if (abbr.charAt(j) != word.charAt(i)){
                    return false;
                }
                i++;
                j++;
            }
        }
        return i==wordLength && j == abbrLength;
    }

    public static void main(String[] args) {
        String s = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(valid(s, abbr));
        String s1 = "apple";
        String abbr1 = "a2e";
        System.out.println(valid(s1, abbr1));
    }
}
