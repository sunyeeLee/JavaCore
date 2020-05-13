package com.sunyee.javacore.base.lambda;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。
 * 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic s，
 * 描述流中元素的各种摘要数据。在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum() 和 getAverage()
 * 方法来获得列表的所有元素的总和及平均值。
 * Created by lishunyi on 2019/9/23
 */
public class SummaryStatistics {

    public static void summaryStatistics(List<Integer> numbers){
        DoubleSummaryStatistics stats = numbers.stream().mapToDouble(x -> x).summaryStatistics();
        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("sum: " + stats.getSum());
        System.out.println("count: " + stats.getCount());
        System.out.println("average: "+ stats.getAverage());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        summaryStatistics(numbers);
    }


}
