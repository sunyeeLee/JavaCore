package com.sunyee.javacore.base.concurrent.thinking_in_java;

/**
 * inheriting directly from the thread class
 * Created by lishunyi on 2020/4/16
 */
public class SimpleThread extends Thread {

    private int countDown = 5;
    private static int threadId = 0;

    public SimpleThread(){
        super(Integer.toString(++threadId));
    }

    public String toString(){
        return "#" + getName() + "(" + countDown + ")";
    }

    public void run(){
        while (true){
            System.out.println(this);
            if (--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            Thread thread = new SimpleThread();
            thread.start();
        }
    }
}
