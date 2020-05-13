package com.sunyee.javacore.base.concurrent;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lishunyi on 2020/4/26
 */
public class ReentrantLockWithExpireTime implements Runnable {
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            boolean hasLock = lock.tryLock(5, TimeUnit.SECONDS);
            if (hasLock){
                Thread.sleep(6000);
            } else {
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockWithExpireTime test = new ReentrantLockWithExpireTime();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
    }
}
