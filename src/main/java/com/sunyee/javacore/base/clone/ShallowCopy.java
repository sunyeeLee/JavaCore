package com.sunyee.javacore.base.clone;

/**
 * 浅拷贝: 拷贝对象与原始对象的引用类型为同一引用
 * Created by lishunyi on 2019/5/20
 */
public class ShallowCopy implements Cloneable {
    private int[] arr;

    public ShallowCopy(){
        arr = new int[10];
        for(int i= 0; i < arr.length; i++){
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
    protected ShallowCopy clone() throws CloneNotSupportedException {
        return (ShallowCopy) super.clone();
    }

    public static void main(String[] args) {
        ShallowCopy e1 = new ShallowCopy();
        ShallowCopy e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 222
    }
}
