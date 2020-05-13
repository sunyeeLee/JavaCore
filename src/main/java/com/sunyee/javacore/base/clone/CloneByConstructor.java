package com.sunyee.javacore.base.clone;

/**
 * clone() 的替代方案
 *
 * 使用 clone() 方法来拷贝一个对象即复杂又有风险，它会抛出异常，并且还需要类型转换。
 * Effective Java 书上讲到，最好不要去使用 clone()，可以使用拷贝构造函数或者拷贝工厂来拷贝一个对象。
 * Created by lishunyi on 2019/5/20
 */
public class CloneByConstructor {

    private int[] arr;

    public CloneByConstructor() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }


    public CloneByConstructor(CloneByConstructor original){
        arr = new int[original.arr.length];
        for (int i = 0; i< arr.length; i++){
            arr[i] = original.arr[i];
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    public static void main(String[] args) {
        CloneByConstructor e1 = new CloneByConstructor();
        CloneByConstructor e2 = new CloneByConstructor(e1);
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 2
    }
}
