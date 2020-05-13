package com.sunyee.javacore.base.concurrent.synchonized;

/**
 * synchronized作用于不同实例的方法
 * Created by lishunyi on 2020/4/14
 */
public class AccountingSyncBad implements Runnable {

    static int i = 0;

    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for (int j=0; j < 100000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new AccountingSyncBad());
        Thread thread2 = new Thread(new AccountingSyncBad());
        thread1.start();
        thread2.start();
        //join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
