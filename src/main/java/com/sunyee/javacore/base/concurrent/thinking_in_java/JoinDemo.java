package com.sunyee.javacore.base.concurrent.thinking_in_java;

/**
 * understanding join()
 *
 * 一个线程在其他线程的基础上调用join()方法， 其效果是等待一段时间直到第二个线程结束
 * 才继续执行。如果某个线程在另一个线程t上调用join()， 此线程将被挂起，直到目标线程t结束才恢复运行
 * Created by lishunyi on 2020/4/16
 */

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name, int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    public void run(){
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. " +
            "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run(){
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class JoinDemo {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("sleepy", 1500);
        Sleeper grumpy = new Sleeper("grumpy", 1500);

        Joiner dopey = new Joiner("dopey", sleepy);
        Joiner doc = new Joiner("doc", grumpy);
        grumpy.interrupt();
    }



}
