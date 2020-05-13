package com.sunyee.javacore.base.concurrent.thinking_in_java;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *防止任务在共享资源上产生冲突的第二种方式是根除对变量的共享。线程本地存储是一种自动化机制，
 * 可以为使用相同变量的每个不同的线程都创建不同的存储。他们使得你可以将状态鱼线程关联起来。
 *
 * Automatically giving each thread its own storage
 * Created by lishunyi on 2020/4/21
 */


class Accessor implements Runnable{

    private final int id;
    public Accessor(int id){
        this.id = id;
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString(){
        return "#"+id + ": "+ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random random = new Random(47);

        @Override
        protected synchronized Integer initialValue(){
            return random.nextInt(10000);
        }
    };

    public static void increment(){
        value.set(value.get() + 1);
    }

    public static int get(){
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i<5; i++){
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);  // run for a while
        exec.shutdownNow();

    }
}
