package com.sunyee.javacore.base.concurrent;

import java.util.Date;

/**
 * ThreadLocal 是一种多线程间并发访问变量的解决方案。不提供锁，以空间换时间的手段，为每个线程提供变量的独立副本，
 * 以保障线程安全，因此它不是一种数据共享的解决方案。
 * ThreadLocal一定程度上减少了锁竞争。
 * Created by lishunyi on 2019/7/11
 */
public class ThreadLocalTest implements Runnable{
    public static final ThreadLocal<Date> localvar = new ThreadLocal<Date>();

    private long time;

    public ThreadLocalTest(Long time){
        this.time = time;
    }
    @Override
    public void run() {
        Date d = new Date(this.time);
        for (int i = 0; i < 10; i++){
            localvar.set(d);
            if (localvar.get().getTime() != time){
                System.out.println("id= " + time + "localvar= " +localvar.get().getTime());
            } else {
                System.out.println("current thread: " + Thread.currentThread().getName() + " date: " +time);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++){
            Long time = System.currentTimeMillis();
            new Thread(new ThreadLocalTest(time)).start();
        }
    }
}
