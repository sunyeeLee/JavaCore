package com.sunyee.javacore.base.innerclass;

/**
 * 外部类能否访问内部类的private元素
 * Created by lishunyi on 2019/6/19
 */
public class AccessPrivateInInnerClass {
    class InnerClass{
        private int i = 10;

        public int getValue(){
            return i;
        }
    }

    public InnerClass getInnerClass(){
        return new InnerClass();
    }

    public static void main(String[] args) {
        AccessPrivateInInnerClass outerClass = new AccessPrivateInInnerClass();
        System.out.println(outerClass.getInnerClass().i);
    }
}
