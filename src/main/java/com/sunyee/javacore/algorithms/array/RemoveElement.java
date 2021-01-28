package com.sunyee.javacore.algorithms.array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并「原地」修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * Created by lishunyi on 2021/1/28
 */
public class RemoveElement {

    public static int removeByForLoop(int[] array, int target) {
        int n = array.length;
        for (int i = 0; i < n; i++){
            if (array[i] == target){ // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < n; j++){
                    array[j-1] = array[j];
                }
                i--; // 因为下表i以后的数值都向前移动了一位，所以i也向前移动一位
                n--; // 此时数组的大小-1
            }
        }
        return n;
    }

    /**
     * 使用快慢指针
     * @param array
     * @param target
     * @return
     */
    public static int removeByDoublePoint(int[] array, int target){
        int slowIndex = 0;
        for (int fastIndex=0; fastIndex< array.length; fastIndex++){
            if (target != array[fastIndex]){
                array[slowIndex++] = fastIndex;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,2,3,0,4,2};
        System.out.println(removeByDoublePoint(array, 2));
    }
}
