package com.sunyee.javacore.algorithms.base;

/**
 * 题目：已知 sqrt (2)约等于 1.414，要求不用数学库，求 sqrt (2)精确到小数点后 10 位。
 *
 * 参考答案：
 *
 * * 考察点
 *
 * 基础算法的灵活应用能力（二分法学过数据结构的同学都知道，但不一定往这个方向考虑；如果学过数值计算的同学，应该还要能想到牛顿迭代法并解释清楚）
 * 退出条件设计
 * * 解决办法
 *
 * 1. 已知 sqrt(2)约等于 1.414，那么就可以在(1.4, 1.5)区间做二分
 *
 * 查找，如： a) high=>1.5 b) low=>1.4 c) mid => (high+low)/2=1.45 d) 1.45*1.45>2 ? high=>1.45 : low => 1.45 e) 循环到 c)
 *
 * 2. 退出条件
 *
 * a) 前后两次的差值的绝对值<=0.0000000001, 则可退出
 * Created by lishunyi on 2019/7/22
 */
public class CalculationWithoutMathLibrary {

    private static final double CONDITION = 0.0000000001;

    /**
     * 求整数平方根
     * @param k 保留k位
     */
    public static void sqrt(int k){
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2;
        while ((high - low)> CONDITION){
            if (mid * mid > 2){
                high = mid;
            } else {
                low = mid;  //1.4142135623376817
            }
            mid = (low + high) / 2;
        }
        int index = String.valueOf(mid).indexOf(".");
        int offset = k + 1;
        String finalMid = String.valueOf(mid).substring(0, index + offset);
        System.out.println("sqrt(2): " + finalMid);
    }

    public static void main(String[] args) {
        sqrt(11);
        System.out.println("sqrt 2 in math library: " + Math.sqrt(2));
    }
}
