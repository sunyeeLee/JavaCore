package com.sunyee.javacore.base.concurrent.synchonized;

import java.util.concurrent.TimeUnit;

/**
 * 死锁demo
 * Created by lishunyi on 2020/5/13
 */
public class DeadLockDemo implements Runnable{

    public static int flag = 1;

    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 此时 flag = " + flag);
        if (flag == 1){
            synchronized (o1){
                try {
                    System.out.println("我是" + Thread.currentThread().getName() + "锁住 o1");
                    TimeUnit.SECONDS.sleep(3L);
                    System.out.println(Thread.currentThread().getName() + "醒来->准备获取 o2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "拿到 o2");
                }
            }
        }

        if (flag == 0){
            synchronized (o2){
                try {
                    System.out.println("我是" + Thread.currentThread().getName() + "锁住 o2");
                    TimeUnit.SECONDS.sleep(3L);
                    System.out.println(Thread.currentThread().getName() + "醒来->准备获取 o1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + "拿到 o1");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockDemo deadLockDemo1 = new DeadLockDemo();
        DeadLockDemo deadLockDemo2 = new DeadLockDemo();
        Thread thread1 = new Thread(deadLockDemo1);
        deadLockDemo1.flag = 1;
        thread1.start();
        TimeUnit.SECONDS.sleep(1L);
        deadLockDemo1.flag = 0;
        Thread thread2 = new Thread(deadLockDemo2);
        thread2.start();
    }
}
