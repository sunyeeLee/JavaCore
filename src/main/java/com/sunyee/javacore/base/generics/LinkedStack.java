package com.sunyee.javacore.base.generics;

/**
 * Created by lishunyi on 2020/4/9
 */
public class LinkedStack<T> {

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s: "i am a hero".split(" ")){
            lss.push(s);
        }
        String item;
        while((item = lss.pop()) != null){
            System.out.println(item);
        }
    }

    public void push(T item){
        top = new Node<>(item, this.top);
    }

    public T pop(){
        T result = top.item;
        if (!top.end()){
            top = top.next;
        }
        return result;
    }

    private Node<T> top = new Node<>(); //end sentinel  末端哨兵

    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){
            this.item = null;
            this.next = null;
        }

        Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        }

        public boolean end(){
            return item == null && next == null;
        }
    }
}
