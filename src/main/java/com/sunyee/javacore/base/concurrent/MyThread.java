package com.sunyee.javacore.base.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现多线程
 * 1.实现runnable
 * 2.实现callable
 * 3.继承
 * Created by lishunyi on 2019/5/24
 */
public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("runnable");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread runnable = new MyThread();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Main");
    }
}

class MyThread1 implements Callable{

    @Override
    public String call() throws Exception {
        return "callable";
    }
}

class MyThread2 extends Thread{

    @Override
    public void run(){
        System.out.println("extend by thread");
    }
}
