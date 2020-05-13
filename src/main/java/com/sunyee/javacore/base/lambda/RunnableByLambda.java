package com.sunyee.javacore.base.lambda;

/**
 * Created by lishunyi on 2019/9/23
 */
public class RunnableByLambda {
    public static void main(String[] args) {
        // old way
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Old way");
            }
        }).start();


        // new way by lambda expression
        new Thread(() -> System.out.println("New way")).start();
    }
}
