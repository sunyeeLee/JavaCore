package com.sunyee.javacore.base.concurrent;

/**
 * Created by lishunyi on 2020/4/26
 */
public class Child extends Father implements Runnable{

    public static void main(String[] args) {
        Child child = new Child();
        for (int i=0; i<10; i++){
            new Thread(child).start();
        }
    }
    public synchronized void doSomething(){
        System.out.println("1child doSomething()");
        doAnotherThing();
    }

    public synchronized void doAnotherThing(){
        super.doSomething();
        System.out.println("3child doAnotherThing()");
    }

    @Override
    public void run() {
        doSomething();
    }
}

class Father{
    public synchronized void doSomething(){
        System.out.println("2father doSomething()");
    }
}
