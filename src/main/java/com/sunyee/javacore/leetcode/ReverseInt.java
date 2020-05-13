package com.sunyee.javacore.leetcode;

/**
 * 整数反转
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *  Created by lishunyi on 2019/9/26
 */
public class ReverseInt {

    public static int reverse(int n){
        int rev = 0;
        while (n != 0){
            int pop = n % 10;
            //如果已经反转内容rev大于Integr最大值/10,那么一定溢出；
            // 如果最rev反转内容等于最大值/10且最后一位pop的数字大于7，那么就从正数这边溢出了
            //另外一种就是从负数那边溢出了
            if((rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7))
                    ||rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)){
                return 0;
            }
            rev = rev * 10 + pop;
            n = n / 10;
        }
        return rev;
    }

    public static void main(String[] args){
        System.out.println(reverse(-123));
        System.out.println(reverse(Integer.MAX_VALUE + 1));
        System.out.println(reverse(120));
    }
}
