package com.sunyee.javacore.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符串逆转
 * Created by lishunyi on 2019/4/11
 */
public class ReverseString {
    final static String s1 = "lishunyi";

    public static void reverseString(String s){
        String[] strArr = s.split("");
        List<String> list = Arrays.asList(strArr);
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void reverseString2(String s){
        System.out.println(new StringBuilder(s).reverse().toString());
    }

}
