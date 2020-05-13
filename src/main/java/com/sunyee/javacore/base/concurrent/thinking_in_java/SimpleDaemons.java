package com.sunyee.javacore.base.concurrent.thinking_in_java;

import java.util.concurrent.TimeUnit;

/**
 * Created by lishunyi on 2020/4/16
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10; i++){
            Thread daemon =new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("all daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
