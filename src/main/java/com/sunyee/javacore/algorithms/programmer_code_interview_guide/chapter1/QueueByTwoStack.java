package com.sunyee.javacore.algorithms.programmer_code_interview_guide.chapter1;

import java.util.Stack;

/**
 * 编写一个类，用两个栈实现队列，支持队列的基本操作(add, poll, peek)
 *
 * 栈的特点为先入后出， 队列的特点为先进先出。
 *
 * 思路：其中一个栈为压入栈，记做stackPush; 另一个栈为弹出栈，记做stackPop。
 *
 * 注意事项：1。如果stackPush要往stackPop中压入数据，必须一次性把stackPush中的数据压入
 *          2。如果stackPo不为空，stackPush绝对不能像stackPop中压入数据。
 *          上述两点需要同时满足!!!
 * Created by lishunyi on 2020/4/20
 */
public class QueueByTwoStack<T> {

    private Stack<T> stackPush = new Stack();
    private Stack<T> stackPop = new Stack();


    private void pushToPop(){
        if (stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(T value){
        stackPush.push(value);
        pushToPop();
    }

    public T poll(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("empty stack");
        }
        pushToPop();
        return stackPop.pop();
    }

    public T peek(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("empty stack");
        }
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        QueueByTwoStack<Integer> queue = new QueueByTwoStack<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());   //1
        System.out.println(queue.poll());   //1
        System.out.println(queue.poll());   //2
    }
}
