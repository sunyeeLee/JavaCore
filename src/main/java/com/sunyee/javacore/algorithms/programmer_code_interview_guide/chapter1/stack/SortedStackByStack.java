package com.sunyee.javacore.algorithms.programmer_code_interview_guide.chapter1.stack;

import java.util.Stack;

/**
 * 【题目】
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 *
 * 【解答】
 * 将要排序的栈记为stack，申请的辅助栈记为help。在stack上执行pop操作，弹出的元素记为cur。
 * ● 如果cur小于或等于help的栈顶元素，则将cur直接压入help；
 * ● 如果cur大于help的栈顶元素，则将help的元素逐一弹出，逐一压入stack，直到cur小于或等于help的栈顶元素，再将cur压入help。
 *    一直执行以上操作，直到stack中的全部元素都压入到help。最后将help中的所有元素逐一压入stack，即完成排序。
 */
public class SortedStackByStack {

    public static void sortedStack(Stack<Integer> stack){
        if (stack == null || stack.isEmpty()){
            throw new RuntimeException("empty stack!");
        }
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        sortedStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
