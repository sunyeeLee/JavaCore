package com.sunyee.javacore.algorithms.programmer_code_interview_guide.chapter1.stack;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 *
 * 要求：
 *  1.pop、push、getMin操作的时间复杂度都是O(1)
 *
 *  2.设计的栈类型可以使用现成的栈结构
 *
 *
 *  解法： 需要2个栈。一个栈用作保存栈中的元，其功能和正常的栈没有区别，这个栈记为stackData；
 *          另一个栈用作保存每一步的最小值，这个栈记为stackMin。。
 *
 *
 */
public class StackCanGetMin {
    private Stack<Integer> stackData = new Stack<>();

    private Stack<Integer> stackMin = new Stack<>();


    public void push(Integer value){
        if (stackMin.isEmpty()){
            stackMin.push(value);
        } else if (value <= getMin()){
            stackMin.push(value);
        }
        stackData.push(value);
    }

    public Integer pop(){
        if (stackData.isEmpty() || stackMin.isEmpty()){
            throw new RuntimeException("un-supported operator, stack is empty!!!");
        }
        int value = stackData.pop();
        if (value == getMin()){
            stackMin.pop(); //此时弹出stackMin的栈顶元素
        }
        return value;
    }

    public Integer getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("stack is empty!!!");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        StackCanGetMin stack = new StackCanGetMin();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        System.out.println("min value: " + stack.getMin()); //1
        stack.pop();    //delete the 1
        System.out.println("min value: " + stack.getMin()); //2
        stack.pop();    //delete the 2
        System.out.println("min value: " + stack.getMin()); //3

    }
}
