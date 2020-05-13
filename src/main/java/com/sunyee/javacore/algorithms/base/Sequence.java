package com.sunyee.javacore.algorithms.base;

/**
 * Created by lishunyi on 2019/8/16
 */
public class Sequence {

    private Object[] items;

    private int i = 0;

    public Sequence(int size){
        items = new Object[size];
    }

    public void add(Object item){
        if (i < items.length){
            items[i++] = item;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selector{
        private int i = 0;

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public boolean end() {
            return (i == items.length);
        }

        @Override
        public void next() {
            if (i < items.length){
                i ++;
            }
        }
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i=0; i<10; i++){
            sequence.add(i);
        }

        Selector selector = sequence.selector();
        while(!selector.end()){
            System.out.println("current: " + selector.current());
            selector.next();
        }
    }

}
