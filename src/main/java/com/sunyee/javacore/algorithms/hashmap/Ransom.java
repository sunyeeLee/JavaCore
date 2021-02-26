package com.sunyee.javacore.algorithms.hashmap;

/**
 * 第383题. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 「注意：」
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false canConstruct("aa", "aab") -> true
 *
 *
 * Created by lishunyi on 2021/2/25
 */
public class Ransom {

    public static boolean solutionByHashMap(){
        return false;
    }

    public static boolean solutionByArray(String ransom, String magazine){
        int[] record = new int[26]; //维护一个26大小的数组，用于存放magazine中出现字母的次数
        char[] magazineArray = magazine.toCharArray();
        char[] ransomArray = ransom.toCharArray();

        for (int i = 0; i < magazineArray.length; i++){
            int recordIndex = magazineArray[i] - 'a';
            // 通过recode数据记录 magazine里各个字符出现次数
            record[recordIndex] = record[recordIndex] + 1;
        }

        for (int i = 0; i < ransomArray.length; i++){
            int recordIndex = ransomArray[i] - 'a';
            int newRecord = record[recordIndex] - 1;
            record[recordIndex] = newRecord;
            if (newRecord < 0){
                // 出现小于0的情况，说明magazine不满足情况
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransom = "aba";
//        String magazine = "abcca";    // true
        String magazine = "abccc";      // false
        System.out.println(solutionByArray(ransom, magazine));
    }
}
