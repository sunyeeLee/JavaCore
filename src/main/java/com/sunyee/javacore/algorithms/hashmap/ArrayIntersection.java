package com.sunyee.javacore.algorithms.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 第349题. 两个数组的交集
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 * 示例1: 输入: nums1 = [1,2,2,1], nums2=[2,2]
 *       输出[2]
 *
 * 示例2: 输入: nums1 = [4,9.5], nums2 = [9,4,9,8,4]
 *       输出: [9,4]
 *
 * 「说明：」
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class ArrayIntersection {
    public static Integer[] getIntersection(int[] nums1, int[] nums2){
        Set<Integer> nums1Set = new HashSet();
        Set<Integer> resultSet = new HashSet();
        for (int i = 0 ; i < nums1.length; i++){
            nums1Set.add(nums1[i]);
        }
        for (int i = 0 ; i < nums2.length; i++){
            if (nums1Set.contains(nums2[i])){
                resultSet.add(nums2[i]);
            }
        }
        return resultSet.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        for (Integer num: getIntersection(nums1, nums2)){
            System.out.println(num);
        }
    }
}
