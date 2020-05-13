package com.sunyee.javacore.base.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * predicate: 断言
 *
 * 除了在语言层面支持函数式编程风格，Java 8也添加了一个包，叫做 java.util.function。
 * 它包含了很多类，用来支持Java的函数式编程。其中一个便是Predicate，使用 java.util.function.Predicate
 * 函数式接口以及lambda表达式，可以向API方法添加逻辑，用更少的代码支持更多的动态行为。下面是Java 8 Predicate
 * 的例子，展示了过滤集合数据的多种常用方法。Predicate接口非常适用于做过滤。
 * Created by lishunyi on 2019/9/23
 */
public class LambdaAndPredicate {

    public static void filter(List<String> names, Predicate<String> condition){
        names.stream().filter(name -> condition.test(name)).forEach(n -> System.out.println(n + " "));
    }

    public static void filterByTwoPredicate(List<String> names, Predicate<String> condition1, Predicate<String> condition2){
        names.stream().filter(condition1.and(condition2)).forEach(n -> System.out.println( n + " which starts with J and for letter long!"));
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java", "Scale", "C++", "Python", "Lisp");

        System.out.println("Languages which start with J");
        filter(names, (str) -> str.startsWith("J"));

        System.out.println("Languages which length greater than 4");
        filter(names, (str) -> str.length() > 4);

        System.out.println("Print all languages");
        filter(names, str -> true);

        System.out.println("Print no languages");
        filter(names, str -> false);

        System.out.println("filter by two predicate");
        filterByTwoPredicate(names, str -> str.startsWith("J"), str -> str.length() == 4);
    }
}
