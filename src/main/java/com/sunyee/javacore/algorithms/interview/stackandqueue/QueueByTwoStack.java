package com.sunyee.javacore.algorithms.interview.stackandqueue;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 由两个栈组成队列
 *
 * 思考点: 栈的特点是先进后出， 队列的特点是先进先出。 因此2个栈刚好可以实现队列
 *
 * 具体实现：
 *      其中一个栈作为压入栈，负责压入数据， 记做stackPush。另一个栈作为弹出栈，弹出数据时只从该栈弹出，记做stackPop。
 *
 *
 * 注意点:
 *      1. 如果stackPush要向stackPop压入数据，只能一次性把数据全部压入.
 *      2. 如果stackPop不为空，stackPush绝不能向stackPop中压入数据。
 *      违反以上2点都会发生错误
 * Created by lishunyi on 2019/12/10
 */
public class QueueByTwoStack {
    private Stack<Integer> stackPush;    //压入栈
    private Stack<Integer> stackPop;     //弹出栈

    public QueueByTwoStack(){
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(Integer pushInt){
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!!!");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!!!");
        }
        pushToPop();
        return stackPop.peek();
    }

    /**
     * stackPush往stackPop栈压入数据
     */
    private void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueByTwoStack queue = new QueueByTwoStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        LinkedBlockingQueue queue1 = new LinkedBlockingQueue();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        System.out.println(queue1.peek());
        System.out.println(queue1.poll());

    }
}
