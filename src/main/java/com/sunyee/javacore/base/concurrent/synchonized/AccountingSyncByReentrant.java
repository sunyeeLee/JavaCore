package com.sunyee.javacore.base.concurrent.synchonized;

/**
 * synchronized的可重入性
 * Created by lishunyi on 2020/4/14
 */
public class AccountingSyncByReentrant implements Runnable{
    static int i =0;

    static int j = 0;
    public synchronized void increase(){
        j++;
    }

    @Override
    public void run() {
        for (int k = 0; k<1000000; k++){
            synchronized (this){
                i++;
                increase(); //synchronized锁的可重入性
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSyncByReentrant instance = new AccountingSyncByReentrant();
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
        System.out.println(j);
    }
}
