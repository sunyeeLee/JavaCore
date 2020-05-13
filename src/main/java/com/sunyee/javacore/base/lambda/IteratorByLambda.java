package com.sunyee.javacore.base.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lishunyi on 2019/9/23
 */
public class IteratorByLambda {

    public static void main(String[] args) {
        List<String> features = Arrays.asList("Lambdas", "Default methods", "Stream APi", "Date and Time API");

        // old way by for-each expression
        for (String feature: features){
            System.out.println(feature);
        }

        //new way by lambda expression
        features.forEach(System.out::println);
    }
}
