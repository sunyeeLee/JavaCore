package com.sunyee.javacore.base.concurrent;

/**
 * 生产者消费者问题
 * 利用Object.wait()和Object.notify()方法进行线程间的通信
 * Created by lishunyi on 2019/6/25
 */
public class ProducerAndConsumerWithWaitAndNotify {
    private static int count = 0;

    private static final int FULL = 10;

    private final String lock = "LOCK";

    class Producer implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //判断count是否满了
                synchronized (lock){
                    while(count == FULL){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count ++;
                    System.out.println("生产者: " + Thread.currentThread().getName() + "生产, 目前共有: " + count);
                    lock.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable{


        @Override
        public void run() {
            for (int i = 0; i < 10 ; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock){
                    while(count == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("消费者： " + Thread.currentThread().getName() + "消费, 目前共有： " + count);
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerWithWaitAndNotify bucket = new ProducerAndConsumerWithWaitAndNotify();
        for(int i = 0; i < 4; i++){
            new Thread(bucket.new Producer()).start();
        }
        for (int i = 0; i < 4; i++){
            new Thread(bucket.new Consumer()).start();
        }
    }
}
