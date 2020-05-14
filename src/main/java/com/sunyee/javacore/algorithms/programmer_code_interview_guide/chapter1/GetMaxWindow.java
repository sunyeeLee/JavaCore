package com.sunyee.javacore.algorithms.programmer_code_interview_guide.chapter1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 例如，数组为[4，3，5，4，3，3，6，7]，窗口大小为3时：
 * 如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。请实现一个函数。
 * ● 输入：整型数组arr，窗口大小为w。
 * ● 输出：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。以本题为例，
 *          结果应该返回{5，5，5，4，6，7}
 *
 * 假设数组长度为 N，窗口大小为 w，如果做出时间复杂度为 O（N×w）的解法是不能让面试官满意的，
 * 本题要求面试者想出时间复杂度为O（N）的实现。本题的关键在于利用双端队列来实现窗口最大值的更新。
 * 首先生成双端队列 qmax，qmax中存放数组arr中的下标。假设遍历到arr[i]，qmax的放入规则为：
 * 1.如果qmax为空，直接把下标i放进qmax，放入过程结束。
 * 2.如果qmax不为空，取出当前qmax队尾存放的下标，假设为j。
 *      1）如果arr[j]＞arr[i]，直接把下标i放进qmax的队尾，放入过程结束。
 *      2）如果arr[j]＜=arr[i]，把j从qmax中弹出，重复qmax的放入规则。
 * Created by lishunyi on 2020/5/13
 */
public class GetMaxWindow {
    public int[] getMaxWindow(int[] array, int windowSize){
        if (array == null || windowSize < 1 || array.length < windowSize){
            return array;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[array.length - windowSize + 1];
        int index = 0;
        for (int i=0; i<array.length; i++){
            while (!qMax.isEmpty() && array[qMax.peekLast()] <= array[i]){
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() == i -windowSize){
                qMax.pollFirst();
            }
            if (i >= windowSize - 1){
                res[index++] = array[qMax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(new GetMaxWindow().getMaxWindow(numbers, 3)));
    }
}
