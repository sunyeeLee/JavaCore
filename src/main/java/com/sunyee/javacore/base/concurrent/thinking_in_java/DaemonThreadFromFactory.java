package com.sunyee.javacore.base.concurrent.thinking_in_java;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lishunyi on 2020/4/16
 */
public class DaemonThreadFromFactory implements Runnable {
    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i=0; i<10; i++){
            executorService.execute(new DaemonThreadFromFactory());
        }
        System.out.println("all daemon started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
