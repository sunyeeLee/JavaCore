package com.sunyee.javacore.base.concurrent.synchonized;

/**
 * synchronized 作用于实例方法
 * Created by lishunyi on 2020/4/14
 */
public class AccountingSync implements Runnable{

    static int i = 0;   // 共享资源(临界资源)

    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for (int i=0; i<100000; i++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSync accountingSync = new AccountingSync();
        Thread thread1 = new Thread(accountingSync);
        Thread thread2 = new Thread(accountingSync);
        thread1.start();
        thread2.start();
        //join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
