package com.sunyee.javacore.base.lambda;

import java.lang.reflect.Array;
import java.util.*;

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

        Set<String> workflowVariableSet = new HashSet<>();
        List<String> strList = new ArrayList<>(Arrays.asList("age", "age,isWhite", "age,name", "name,isWhite"));
        strList.forEach(variable->{
            if (variable.contains(",")){
                String[] variables = variable.split(",");
                workflowVariableSet.addAll(Arrays.asList(variables));
            } else {
                workflowVariableSet.add(variable);
            }
        });
        System.out.println(workflowVariableSet);
    }
}
