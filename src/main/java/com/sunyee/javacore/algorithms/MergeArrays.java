package com.sunyee.javacore.algorithms;

import java.util.Arrays;

/**
 * 示例 1:
     输入: [[1,3],[2,6],[8,10],[15,18]]
     输出: [[1,6],[8,10],[15,18]]
     解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     示例 2:
     输入: [[1,4],[4,5]]
     输出: [[1,5]]
     解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * Created by lishunyi on 2020/5/18
 */
public class MergeArrays {

    public static int[][] merge(int[][] intervals){
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }

        int length = intervals.length;
        int[][] result = new int[length][intervals[1].length];
        int index = 0;
        for (int i=0; i<length; i++){
            boolean notIn = false;
            for (int j=0;  j<result.length; j++){
                if (!(intervals[i][0] > result[j][1] || intervals[i][1] < result[j][0])){
                    result[j][0] = Math.min(intervals[i][0], result[j][0]);
                    result[j][1] = Math.max(intervals[i][1], result[j][1]);
                    notIn = true;
                    break;
                }
            }
            if (!notIn){
                result[index++] = intervals[i];
            }

        }
        int[][] data = new int[index][intervals[1].length];
        System.arraycopy(result, 0, data, 0,
                index);
        return data;
    }


    public static void main(String[] args) {
        int[][] arrays = {{1,3},{2,6},{8,10},{15,18}};
        int[][] arrays2 = {{1,4},{4,5}};
        int[][] result = merge(arrays);
        int[][] result2 = merge(arrays2);
        System.out.println(Arrays.deepToString(result));
        System.out.println(Arrays.deepToString(result2));
    }
}
