package com.sunyee.javacore.base.concurrent.thinking_in_java;

/**
 * adding more threads
 * Created by lishunyi on 2020/4/16
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for LiftOff!!!");
    }
}
