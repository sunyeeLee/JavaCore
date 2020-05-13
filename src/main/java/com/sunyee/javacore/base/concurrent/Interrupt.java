package com.sunyee.javacore.base.concurrent;

/**
 * thread.interrupt()只是修改当前线程的状态为true。
 * Java的中断是一种协作机制。也就是说调用线程对象的interrupt方法并不一定就中断了正在运行的线程，
 * 它只是要求线程自己在合适的时机中断自己。每个线程都有一个boolean的中断状态（不一定就是对象的属性，
 * 事实上，该状态也确实不是Thread的字段），interrupt方法仅仅只是将该状态置为true。对于非阻塞中的线程, 只是改变了中断状态, 即Thread.isInterrupted()将返回true，并不会使程序停止;
 * Created by lishunyi on 2019/5/24
 */
public class Interrupt {

    static class ThreadIntertupt extends Thread{

        @Override
        public void run(){
            //这样使线程t1中断，是不会有效果的，只是更改了中断状态位。
            while(true){
                System.out.println(currentThread().getName());
                Thread.yield();
            }
        }
    }

    static class ThreadInterrupt2 extends Thread{

        //希望非常优雅地终止这个线程，就该这样做
        @Override
        public void run(){
            while(true){
                if (currentThread().isInterrupted()){
                    System.out.println("interrupt");
                    break;
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        ThreadIntertupt thread1 = new ThreadIntertupt();
        thread1.start();
        thread1.interrupt();

//        ThreadInterrupt2 thread2 = new ThreadInterrupt2();
//        thread2.start();
//        thread2.interrupt();
    }
}
