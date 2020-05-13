package com.sunyee.javacore.base.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create a list by filter
 * Created by lishunyi on 2019/9/23
 */
public class FilterAndCollect {

    /**
     * create a new list by filter
     * @param languages
     */
    public static void filter(List<String> languages){
        List<String> filterList = languages.stream().filter(n -> n.length() >=4).collect(Collectors.toList());
        filterList.forEach(System.out::println);
    }

    public static void toUpperCase(List<String> languages){
        List<String> upperCaseList = languages.stream().map(String::toUpperCase).collect(Collectors.toList());
        upperCaseList.forEach(System.out::println);
    }

    public static void distinct(List<Integer> numbers){
        List<Integer> distinct = numbers.stream().map(n -> n * n).distinct().collect(Collectors.toList());
        distinct.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scale", "C++", "Python", "Lisp");
        filter(languages);
        toUpperCase(languages);

        List<Integer> numbers = Arrays.asList(10, 9, 6, 7, 9, 3, 3);
        distinct(numbers);

    }
}
