package com.sunyee.javacore.base.concurrent;


/**
 * 奇偶数交替打印
 * Created by lishunyi on 2019/7/15
 */
public class OddAndEvenNumberInTernPrint {

}
class TwoThreadNumber{
    private int start = 1;

    private volatile boolean flag = false;

    private final String lock = "LOCK";

    class OddNumber implements Runnable{

        private TwoThreadNumber number;

        public OddNumber(TwoThreadNumber number){
            this.number = number;
        }

        @Override
        public void run() {
            while(number.start < 100){
                if (!flag){
                    synchronized (lock) {
                        System.out.println("Thread: " + Thread.currentThread().getName() + " value: " + number.start);
                        number.start ++ ;
                        flag = true;
                    }
                }
            }
        }
    }

    class EvenNumber implements Runnable{

        private TwoThreadNumber number;

        public EvenNumber(TwoThreadNumber number){
            this.number = number;
        }

        @Override
        public void run() {
            while(number.start <= 100){
                synchronized (lock) {
                    if (flag) {
                        System.out.println("Thread: " + Thread.currentThread().getName() + " value: " + number.start);
                        number.start ++;
                        flag = false;
                    }
                }
            }
        }
    }


    class OddNumberByNotify implements Runnable{

        private TwoThreadNumber number;

        public OddNumberByNotify(TwoThreadNumber number){
            this.number = number;
        }

        @Override
        public void run() {
            while(number.start < 100){
                synchronized (lock){
                    if (number.start % 2 != 0){
                        System.out.println("Thread: " + Thread.currentThread().getName() + " value: " + number.start);
                        number.start ++ ;
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

    class EvenNumberByNotify implements Runnable{
        private TwoThreadNumber number;

        public EvenNumberByNotify(TwoThreadNumber number){
            this.number = number;
        }
        @Override
        public void run() {
            while(number.start <= 100){
                synchronized (lock){
                    if (number.start % 2 == 0){
                        System.out.println("Thread: " + Thread.currentThread().getName() + " value: " + number.start);
                        number.start ++ ;
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
        TwoThreadNumber number = new TwoThreadNumber();
        Thread thread1 = new Thread(number.new OddNumberByNotify(number));
        Thread thread2 = new Thread(number.new EvenNumberByNotify(number));
//        Thread thread3 = new Thread(number.new OddNumberByNotify(number));
        thread1.start();
        thread2.start();
//        thread3.start();
    }
}

