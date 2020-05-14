package com.sunyee.javacore.algorithms.introduction_to_algorithms;

import java.util.Arrays;

/**
 * 快速排序体现了分而治之的思想（divide and conquer），通过将大问题划分为小问题。
 *
 * worst-case: the input arrays is sorted or reverse sorted。
 *
 * 改进的话可以让pivot随机选择，使得数组中的每个元素都具有1/n的概率.（randomized quick sort）
 */
public class QuickSort {

    // conquer
    public static void quickSort(int[] arrays, int low, int high){
        if (arrays == null || arrays.length <=1){
            return;
        }
        if (low < high){
            int r = partition(arrays, low, high);
            quickSort(arrays, low, r-1);
            quickSort(arrays, r+1, high);
        }
    }

    //divide
    public static int partition(int[] arrays, int low, int  high){
        // choose the first element in arrays as pivot
        int pivot =  arrays[low];
        int i = 0;  //循环不变量，使得数组中在i左边的元素都小于 arrays[i]， 左边都大于arrays[i]
        for (int j = i + 1; j <= high; j++){
            if (arrays[j] <= pivot){
                i+=1;
                // exchange the arrays[j] and arrays[i]
                exchange(arrays, i, j);
            }
        }
        // exchange the pivot and arrays[i], makes the [0, i-1] elements in arrays are less than arrays[i], and
        // the right size of arrays[i] are greater than arrays[i]
        exchange(arrays, low, i);
        return i;
    }

    public static void exchange(int[] arrays, int low, int high){
        int temp = arrays[high];
        arrays[high] = arrays[low];
        arrays[low] = temp;
    }
    public static void main(String[] args) {
//        int[] arrays = new int[]{6,10,13,5,8,3,2,11};
        int[] arrays = {5,8,6,5,3,9,11,4};
        quickSort(arrays,0,arrays.length-1);
        System.out.println(Arrays.toString(arrays));
    }
}
