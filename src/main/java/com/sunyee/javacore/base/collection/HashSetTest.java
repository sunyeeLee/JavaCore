package com.sunyee.javacore.base.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lishunyi on 2021/3/1
 */
public class HashSetTest {

    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add(null);
        set.forEach(System.out::println);
    }
}
