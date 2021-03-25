package com.sunyee.javacore.base.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by lishunyi on 2021/3/25
 */
public class ListToMap {
    public static void main(String[] args) {
        Test test1 = new Test("1", "a");
        Test test2 = new Test("2", "b");
        Test test3 = new Test("3", "c");
        Test test4 = new Test("3", "d");
        List list = new ArrayList();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        Map<String, Object> map = (Map<String, Object>) list.stream().collect(Collectors.groupingBy(Test::getId));
        System.out.println(map);

        // 不允许有重复key，存在重复key时会报错
        Map<String, Object> map1 = (Map<String, Object>) list.stream().collect(Collectors.toMap(Test::getId, Function.identity()));
        System.out.println(map1);   //报错
    }
}
