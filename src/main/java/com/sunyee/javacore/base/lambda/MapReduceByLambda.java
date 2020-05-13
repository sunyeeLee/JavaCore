package com.sunyee.javacore.base.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lishunyi on 2019/9/23
 */
public class MapReduceByLambda {

    /**
     * plus 12% tax for every tax
     * @param costBeforeTax tax list
     */
    public static void map(List<Integer> costBeforeTax){
        //old way
        for (Integer cost: costBeforeTax){
            double price = cost + 0.12 * cost;
            System.out.println(price);
        }

        //new way
        costBeforeTax.stream().map(n -> n + 0.12 * n).forEach(System.out::println);
    }

    /**
     * puls 12% tax for every tax, and then calculate the sum of taxes.
     * @param costBeforeTax tax list
     */
    public static void mapAndReduce(List<Integer> costBeforeTax){
        // old way
        double total = 0.0;
        for (Integer tax: costBeforeTax){
            double price = 1.12 * tax;
            total += price;
        }
        System.out.println("total tax calculate by old way: " + total);

        //new way
        Double sumOfTax = costBeforeTax.stream().map(tax->1.12 * tax).reduce((sum, tax) -> sum + tax).get();
        System.out.println("total tax calculate by new way: " + sumOfTax);
    }

    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        System.out.println("Different ways between for-each expression and map expression");
        map(costBeforeTax);

        System.out.println("*******************");
        mapAndReduce(costBeforeTax);
    }
}
