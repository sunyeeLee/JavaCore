package com.sunyee.javacore.base.concurrent.thinking_in_java;

/**
 * Created by lishunyi on 2020/4/21
 */
public class DualSync {

    private Object syncObject = new Object();
    public synchronized void f(){
        for (int i=0; i<5; i++){
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g(){
        synchronized (syncObject){
            for (int i=0; i<5; i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        final DualSync sync = new DualSync();
        new Thread(){
            public void run(){
                sync.f();
            }
        }.start();
        sync.g();
    }
}
