package com.sunyee.javacore.base.concurrent.thinking_in_java;

/**
 * 定义任务
 * Demonstration of the Runnable interfaces
 * Created by lishunyi on 2020/4/15
 */
public class LiftOff implements Runnable{

    private int countDown = 10; //default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" +id + "(" + (countDown > 0 ? countDown: "Lift off!!!") + ").";
    }

    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff(10);
        Thread thread = new Thread(liftOff);
        thread.start();
        System.out.println("waiting for lift off!");
    }
}
