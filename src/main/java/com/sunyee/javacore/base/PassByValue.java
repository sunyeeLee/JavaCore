package com.sunyee.javacore.base;

/**
 *  Is Java “pass-by-reference” or “pass-by-value”?
 * Created by lishunyi on 2019/5/21
 */
public class PassByValue {

    public static void change(StringBuffer x, StringBuffer y){
        x.append(y);
        x = y;
    }

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("1");
        StringBuffer b = new StringBuffer("2");
        change(a, b);
        System.out.println(a);
        System.out.println(b);
    }
}


