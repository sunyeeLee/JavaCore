package com.sunyee.javacore.algorithms.introduction_to_algorithms;

import java.util.Arrays;

public class InsertSort {

    public static int[] sorts(int[] arrs){
        if (arrs == null || arrs.length < 1){
            throw new RuntimeException("sequence is empty!!!");
        } else if (arrs.length < 2){
            return arrs;
        }

        for (int i = 1; i < arrs.length; i++){
            int key = arrs[i];
            int j = i-1;
            while (j >= 0 && arrs[j] > key){
                arrs[j + 1] = arrs[j];
                j = j -1;
            }
            arrs[j+1] = key;
        }
        return arrs;
    }
    public static void main(String[] args) {
//        int[] arrs = new int[]{3,4,2,1,5};
//        int[] arrs = new int[]{};
        int[] arrs = new int[]{5,4,3,2,1};
        int[] arrsAfterSort = sorts(arrs);
        System.out.println(Arrays.toString(arrsAfterSort));
    }
}
