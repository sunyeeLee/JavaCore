package com.sunyee.javacore.base.concurrent;

/**
 * 可见性问题: 线程之间对变量的操作是互不可见的。
 * Created by lishunyi on 2019/7/22
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static Thread readerThread = new Thread(new Reader());

    static class Reader implements Runnable{

        @Override
        public void run() {
            while(!ready){
                System.out.println("number: " + number);
            }
        }
    }

    public static void main(String[] args) {
        readerThread.start();
        ready = true;
        number = 233;
    }
}


class Visibility{
}