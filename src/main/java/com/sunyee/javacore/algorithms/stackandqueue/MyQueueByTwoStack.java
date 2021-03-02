package com.sunyee.javacore.algorithms.stackandqueue;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * Created by lishunyi on 2021/3/2
 */
public class MyQueueByTwoStack<E> {

    private Stack<E> stackPush;   //压入栈
    private Stack<E> stackPop;    //弹出栈

    public MyQueueByTwoStack(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public E push(E x){
        stackPush.push(x);
        pushToPop();
        return x;
    }

    public E pop(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!!!");
        }
        pushToPop();
        return stackPop.pop();
    }

    public E peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!!!");
        }
        pushToPop();
        return stackPop.peek();
    }

    public Boolean empty(){
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    private void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueueByTwoStack<Integer> queue = new MyQueueByTwoStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());

        LinkedBlockingQueue queue1 = new LinkedBlockingQueue();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        System.out.println(queue1.peek());
        System.out.println(queue1.poll());
        System.out.println(queue1.isEmpty());
    }
}
