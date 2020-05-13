package com.sunyee.javacore.base.concurrent.thinking_in_java;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lishunyi on 2020/4/21
 */
public class AtomicIntegerTest implements Runnable {
    private AtomicInteger  i = new AtomicInteger(0);

    public int getValue(){
        return i.get();
    }

    private int evenIncrement(){
        return i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        }, 5000);       //Terminate after 5 seconds
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while(true){
            int val = ait.getValue();
            if (val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
