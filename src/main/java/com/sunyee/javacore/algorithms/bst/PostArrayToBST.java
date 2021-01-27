package com.sunyee.javacore.algorithms.bst;

/**
 * 给定一个数组arr[0, n-1]，构建一颗搜索二叉树。其中该数组为后续遍历方式
 */
public class PostArrayToBST {
    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node postArrayToBST1(int[] arr){
        return process3(arr, 0, arr.length-1);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static Node process1(int[] arr, int left, int right){
        if (left > right){
            return null;
        }

        Node head = new Node(arr[right]);
        if (left == right){
            return head;
        }
        int middle = left-1;    // 考虑极端情况，如左边全是小于或大于头结点的数，就只进行构建左子树或右子树
        for (int i = left; i < right; i++){
            if (arr[i] < arr[right]){
                middle = i;
            }
        }
        head.left = process1(arr, left, middle);
        head.right = process1(arr, middle+1, right-1);
        return head;
    }

    public static Node process2(int[] arr, int left, int right){
        Node head = new Node(arr[right]);
        if (left == right){
            return head;
        }
        int m = -1;
        for (int i = 0; i < right; i++){
            if (arr[i] < arr[right]){
                m = i;
            }
        }

        if (m == -1){
            // m遍历的时候没更新，说明右边全是大于头结点的数，此时只构建右子树
            head.right = process2(arr, left, right-1);
        } else if (m == right-1){
            // 此时右边全是小于头结点的数，只构建左子树
            head.left = process2(arr, left, right-1);
        } else {
            head.left = process2(arr, left, m);
            head.right = process2(arr, m+1, right-1);
        }
        return head;
    }

    /**
     * 遍历判断节点的时候采用二分查找方式
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static Node process3(int[] arr, int left, int right){

        if (left > right){
            return null;
        }
        Node head = new Node(arr[right]);
        if (left == right){
            return head;
        }

        // 二分查找进行遍历
        int m = left - 1;
        int l = left;
        int r = right - 1;
        while (l <= r){
//            int mid = (left + right) / 2;   //次数int类型可能会溢出
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < arr[right]){
                m = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        head.left = process3(arr, left, m);
        head.right = process3(arr, m + 1, right - 1);
        return head;
    }



    public static void beforeArray(Node bst){
        if (bst == null){
            return;
        }
        beforeArray(bst.left);
        System.out.println(bst.value);
        beforeArray(bst.right);
    }

    public static void main(String[] args) {
        int[] postArr = {2,4,3,6,8,7,5};
        Node bst = postArrayToBST1(postArr);
        System.out.println(bst.value);
        System.out.println("**************************");
        beforeArray(bst);
    }
}
