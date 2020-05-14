package com.sunyee.javacore.base.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者问题
 * 利用ReentrantLock（可重入锁、可中断锁、公平锁、时间锁）和Condition进行线程间通信
 * Created by lishunyi on 2019/6/25
 */
public class ProducerAndConsumerWithReentrantLock {

    private static int count = 0;

    private static int FULL = 10;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition FULL_CONDITION = lock.newCondition();

    private final Condition NOT_FULL_CONDITION = lock.newCondition();


    class Producer implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try{
                    while (count == FULL){
                        try {
                            FULL_CONDITION.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("生产者: " + Thread.currentThread().getName() + "生产, 目前共有: " + count);
                    NOT_FULL_CONDITION.signal();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();

                try{
                    while(count == 0){
                        NOT_FULL_CONDITION.await();
                    }
                    count--;
                    System.out.println("消费者： " + Thread.currentThread().getName() + "消费, 目前共有： " + count);
                    FULL_CONDITION.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerWithReentrantLock bucket = new ProducerAndConsumerWithReentrantLock();
        for(int i = 0; i < 4; i++){
            new Thread(bucket.new Producer()).start();
        }
        for (int i = 0; i < 4; i++){
            new Thread(bucket.new Consumer()).start();
        }
    }

}
