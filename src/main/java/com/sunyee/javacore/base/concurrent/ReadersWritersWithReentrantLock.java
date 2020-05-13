package com.sunyee.javacore.base.concurrent;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写者问题
 * Created by lishunyi on 2019/6/25
 */
public class ReadersWritersWithReentrantLock {

    public static void main(String[] args) {
        ReadersWritersWithReentrantLock test = new ReadersWritersWithReentrantLock();
        final ReaderWtiterQueue q3 = test.new ReaderWtiterQueue();
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        q3.get();
                    }
                }
            }.start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        q3.put(new Random().nextInt(10000));
                    }
                }
            }.start();
        }
    }

    class ReaderWtiterQueue{
        private Object data;
        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


        public void get(){
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " be ready to read data!!!");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " have read the data!\tdata: " + data);
            lock.readLock().unlock();
        }

        public void put(Object data){
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " be ready to write data!!!");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " have write the data!\tdata: " + data);
        }
    }

}