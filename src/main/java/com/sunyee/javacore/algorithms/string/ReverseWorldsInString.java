package com.sunyee.javacore.algorithms.string;


import java.util.Arrays;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 思路
 * 「这道题目可以说是综合考察了字符串的多种操作。」
 *
 * 一些同学会使用split库函数，分隔单词，然后定义一个新的string字符串，最后再把单词倒序相加，那么这道题题目就是一道水题了，失去了它的意义。
 *
 * 所以这里我还是提高一下本题的难度：「不要使用辅助空间，空间复杂度要求为O(1)。」
 *
 * 不能使用辅助空间之后，那么只能在原字符串上下功夫了。
 *
 * 想一下，我们将整个字符串都反转过来，那么单词的顺序指定是倒序了，只不过单词本身也倒叙了，那么再把单词反转一下，单词就正过来了。
 *
 * 所以解题思路如下：
 *      移除多余空格
 *      将整个字符串反转
 *      将每个单词反转
 * Created by lishunyi on 2021/2/27
 */
public class ReverseWorldsInString {

    public static String reverseString(String str){
        // 移除多余空格
        char[] charExtraSpacesArray = removeExtraSpaces(str.toCharArray());
        // 翻转整个字符串
        for (int i=0, j=charExtraSpacesArray.length-1; i< (charExtraSpacesArray.length/2); i++, j--){
            swap(charExtraSpacesArray, i , j);
        }
        // 翻转每个单词

        int start = 0; // 反转的单词在字符串里起始位置
        int end = 0; // 反转的单词在字符串里终止位置
        boolean flag = false; // 标记枚举字符串的过程中是否已经进入了单词区间
        for (int i=0; i< charExtraSpacesArray.length; i++){
            if ((!flag) || (charExtraSpacesArray[i] != ' ' && charExtraSpacesArray[i - 1] == ' ')) {
                start = i; // 确定单词起始位置
                flag = true; // 进入单词区间
            }
            // 单词后面有空格的情况，空格就是分词符
            if (flag && charExtraSpacesArray[i] == ' ' && charExtraSpacesArray[i - 1] != ' ') {
                end = i - 1; // 确定单词终止位置
                flag = false; // 结束单词区间
                charExtraSpacesArray = reverse(charExtraSpacesArray, start, end);
            }
            // 最后一个结尾单词之后没有空格的情况
            if (flag && (i == (charExtraSpacesArray.length - 1)) && charExtraSpacesArray[i] != ' ' ) {
                end = i;// 确定单词终止位置
                flag = false; // 结束单词区间
                charExtraSpacesArray = reverse(charExtraSpacesArray, start, end);
            }
        }
        return new String(charExtraSpacesArray);
    }

    private static char[] reverse(char[] charArray, int start, int end){
        for (int i=start, j=end; i< j; i++, j--){
            swap(charArray, i , j);
        }
        return charArray;
    }

    private static void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static char[] removeExtraSpaces(char[] charArray){
        int fastIndex = 0;
        int slowIndex = 0;
        //移除前面的空格
        while (charArray.length > 0 && fastIndex < charArray.length && charArray[fastIndex] == ' '){
            fastIndex++;
        }
        //移除中间的空格
        for (;fastIndex < charArray.length; fastIndex++){
            if (fastIndex - 1 > 0 && charArray[fastIndex] == charArray[fastIndex - 1] && charArray[fastIndex] == ' '){
                continue;
            } else {
                charArray[slowIndex++] = charArray[fastIndex];
            }

        }
        //移除后面的空格
        if (slowIndex - 1 > 0 && charArray[slowIndex-1] == ' '){
            slowIndex -= 1;
        }
        return Arrays.copyOf(charArray, slowIndex);
    }

    public static void main(String[] args) {
        String str = "  hello world!  ";
        System.out.println(reverseString(str));
    }
}
