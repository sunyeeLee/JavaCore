package com.sunyee.javacore.base.concurrent;

/**
 * 交替打印
 * Created by lishunyi on 2021/3/18
 */
class InternPrint {

    private int count = 1;
    private volatile boolean flag = false;
    private final String lock = "lock";

    class PrintAByVolatileThread implements Runnable{
        private String a = "A";
        @Override
        public void run() {
            while (count < 100){
                synchronized (lock){
                    if (!flag){
                        System.out.println(Thread.currentThread().getName() + ": " + a);
                        flag = true;
                        count++;
                    }
                }
            }
        }
    }

    class PrintBByVolatileThread implements Runnable{
        private String b = "B";

        @Override
        public void run() {
            while (count <= 100){
                synchronized (lock){
                    if (flag){
                        System.out.println(Thread.currentThread().getName() + ": " + b);
                        flag = false;
                        count++;
                    }
                }
            }
        }
    }


    class PrintABySignalThread implements Runnable{
        private String a = "A";

        @Override
        public void run() {
            while (count < 100){
                synchronized (lock){
                    if (!flag){
                        System.out.println(Thread.currentThread().getName() + ": " + a);
                        flag = true;
                        count++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class PrintBBySignalThread implements Runnable{
        private String b = "B";

        @Override
        public void run() {
            while (count <= 100){
                synchronized (lock){
                    if (flag){
                        System.out.println(Thread.currentThread().getName() + ": " + b);
                        flag = false;
                        count++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        InternPrint internPrint = new InternPrint();
        Thread thread1 = new Thread(internPrint.new PrintABySignalThread());
        Thread thread2 = new Thread(internPrint.new PrintBBySignalThread());
        thread1.start();
        thread2.start();
    }
}
