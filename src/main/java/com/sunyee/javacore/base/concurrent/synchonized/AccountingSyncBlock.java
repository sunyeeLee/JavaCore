package com.sunyee.javacore.base.concurrent.synchonized;

/**
 * synchronized作用于同步代码块
 * Created by lishunyi on 2020/4/14
 */
public class AccountingSyncBlock implements Runnable {
    static int i=0;

    @Override
    public void run() {
        //对于其他耗时操作不加锁，粒度更小
        //使用同步代码块对变量i进行同步操作，加锁对象为instance
        synchronized (this){
            for (int j=0; j<100000; j++){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSyncBlock accountingSyncBlock = new AccountingSyncBlock();
        Thread thread1 = new Thread(accountingSyncBlock);
        Thread thread2 = new Thread(accountingSyncBlock);
        thread1.start();
        thread2.start();
        //join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
