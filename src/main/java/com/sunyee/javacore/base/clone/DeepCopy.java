package com.sunyee.javacore.base.clone;

/**
 * 深拷贝: 拷贝对象与原始对象的引用类型引用不同引用
 * Created by lishunyi on 2019/5/20
 */
public class DeepCopy implements Cloneable {
    private int[] arr;

    public DeepCopy(){
        arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected DeepCopy clone() throws CloneNotSupportedException {
        DeepCopy result = (DeepCopy) super.clone();
        result.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result.arr[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        DeepCopy e1 = new DeepCopy();
        DeepCopy e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 2
    }
}
