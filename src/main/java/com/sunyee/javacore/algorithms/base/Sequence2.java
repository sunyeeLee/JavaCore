package com.sunyee.javacore.algorithms.base;

/**
 * Created by lishunyi on 2021/1/11
 */
public class Sequence2 {
    private Object[] items;

    private int i = 0;

    public Sequence2(int size){
        items = new Object[size];
    }

    public void add(Object item){
        if (i < items.length){
            items[i++] = item;
        }
    }

    private class SequenceSelector2 implements Selector{

        private int i = 0;

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public boolean end() {
            return i==items.length;
        }

        @Override
        public void next() {
            if (i < items.length){
                i++;
            }
        }
    }
}
