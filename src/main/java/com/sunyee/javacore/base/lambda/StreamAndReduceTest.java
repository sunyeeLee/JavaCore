package com.sunyee.javacore.base.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lishunyi on 2019/9/23
 */
public class StreamAndReduceTest {

    public static void main(String[] args) {
        // old way
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int sum = 0;
        for (Integer n: list){
            int x = n * n;
            sum += x;
        }
        System.out.println(sum);

        //new way by lambda expression
        sum = list.stream().map(n -> n * n).reduce((x, y) -> x + y).get();
        System.out.println(sum);
    }
}
