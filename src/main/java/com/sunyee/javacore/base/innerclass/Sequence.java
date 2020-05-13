package com.sunyee.javacore.base.innerclass;

/**
 * Created by lishunyi on 2020/4/2
 */
public class Sequence {
    private Object[] items;

    private int next = 0;

    public Sequence(int size){
        items = new Object[size];
    }

    public void add(Object item){
        if (next < items.length){
            items[next++] = item;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i =0; i< 10; i++){
            sequence.add(Integer.toString(i));
        }

        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.println("current: " + selector.current());
            selector.next();
        }

    }

    private class SequenceSelector implements Selector{
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length){
                i++;
            }
        }
    }
}

interface  Selector{
    boolean end();

    Object current();

    void next();
}