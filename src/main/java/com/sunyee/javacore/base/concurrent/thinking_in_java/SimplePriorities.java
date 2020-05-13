package com.sunyee.javacore.base.concurrent.thinking_in_java;

/**
 * Created by lishunyi on 2020/4/16
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;  //No optimization
    private int priority;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread() + ": " + countDown;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
    }
}
