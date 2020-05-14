package com.sunyee.javacore.algorithms.programmer_code_interview_guide.chapter1.array;

import java.util.Arrays;

public class SlidingWindow {

    public static int[] slide(int[] array, int windowSize, int stepSize){
       if (array == null || array.length <= 1){
           return array;
       }
       int length = array.length;
        int i = 0;
        int loopSize = length-windowSize + stepSize;
        int[] maxNumberArray = new int[loopSize];
        while(i<loopSize){
            int max = array[i];
            for (int j = i; j < i+windowSize; j++){
                if (array[i+1] >= max){
                    max = array[i+1];
                }
            }
            maxNumberArray[i] = max;
            i+=stepSize;
        }
        return maxNumberArray;

    }


    public static void main(String[] args) {
        int[] array = {3,5,4,2,1,6};
        System.out.println(Arrays.toString(slide(array, 3,1)));
    }
}
