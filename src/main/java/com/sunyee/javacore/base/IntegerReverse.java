package com.sunyee.javacore.base;

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
 * Created by lishunyi on 2019/8/1
 */
public class IntegerReverse {

    public static int reverse(int x){
        int rev = 0;//rev存储反转的数字
        while(x!=0){
            int pop = x%10;//pop表示弹出的数
            //如果已经反转内容rev大于Integr最大值/10,那么一定溢出；
            // 如果最rev反转内容等于最大值/10且最后一位pop的数字大于7，那么就从正数这边溢出了
            //另外一种就是从负数那边溢出了
            if((rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7))
                    ||rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)){
                return 0;
            }
            rev=rev*10+pop;//把pop放到rev后面
            x/=10;//去掉已经pop的内容
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
