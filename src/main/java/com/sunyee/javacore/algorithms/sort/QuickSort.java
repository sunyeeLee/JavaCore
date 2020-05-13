package com.sunyee.javacore.algorithms.sort;
/**
 * 快速排序
 */
public class QuickSort {
	/**
	 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
	 */
    public static void main(String[] args) {
//        int[] list = {10, 6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] list = {2, 1, 3, 4};
        System.out.println("************快速排序************");
        System.out.println("排序前：");
        display(list);
        System.out.println("排序后：");
        quickSort(list, 0, list.length - 1);
        display(list);
    }

    /**
     * 快速排序算法
     */
    public static void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);

            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, point + 1, right);
        }
    }

    /**
     * 分割数组，找到分割点
     */
    public static int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }
            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= first) {
                left++;
            }
            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    /**
     * 交换数组中两个位置的元素
     */
    public static void swap(int[] list, int left, int right) {
        int temp;
        if (list != null && list.length > 0) {
            temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }

    /**
     * 遍历打印
     */
    public static void display(int[] list) {
        if (list != null && list.length > 0) {
            for (int num :list) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }
}


class QuickSort2{

    public static void sort(int[] arr, int left, int right){
        if (arr == null || arr.length <= 1){
            return;
        }
        if (left < right){
            int partition = partition(arr, left, right);
            sort(arr, left, partition - 1);
            sort(arr, partition + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];  //基准数
        while(left < right){
            while(left < right && arr[right] >= pivot){
                right--;
            }
            swap(arr, left, right);

            while (left < right && arr[left] <= pivot){
                left++;
            }
            swap(arr, left, right);
        }
        return left;

    }

    public static void swap(int[] arr, int left, int right){
        if (arr == null || arr.length <= 1){
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 2, 3, 3, 4};
        sort(arr, 0, arr.length - 1);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }
}