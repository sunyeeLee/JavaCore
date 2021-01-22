package com.sunyee.javacore.base;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Collection迭代方式
 * Created by lishunyi on 2021/1/22
 */
public class IteratorWays {

    public static void iteration(List list){

        //普通for循环遍历
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        //增强for循环遍历
        for (Object o: list){
            System.out.println(o);
        }

        //迭代器模式遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //lambda stream遍历
        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> list = ImmutableList.of("Hollis", "hollischuang");
        iteration(list);
    }
}
