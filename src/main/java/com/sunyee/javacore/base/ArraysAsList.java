package com.sunyee.javacore.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lishunyi on 2020/4/7
 */
public class ArraysAsList {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4);

//        intList.add(1);       //can not modify the collection

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
    }
}
