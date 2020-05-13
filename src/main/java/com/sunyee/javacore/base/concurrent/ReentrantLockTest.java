package com.sunyee.javacore.base.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lishunyi on 2020/4/26
 */
public class ReentrantLockTest implements Runnable{

    private ReentrantLock lock = new ReentrantLock();
    private int count =0;

    @Override
    public void run() {
        for (int i=0; i< 100000; i++){
            try{
                lock.lock();
                count++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(test.count);
    }
}
