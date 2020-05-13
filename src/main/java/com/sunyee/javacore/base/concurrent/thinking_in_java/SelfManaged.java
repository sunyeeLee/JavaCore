package com.sunyee.javacore.base.concurrent.thinking_in_java;

/**
 * Created by lishunyi on 2020/4/16
 * A Runnable containing its own driver thread
 */
public class SelfManaged implements Runnable {

    private int countDown = 5;
    private Thread thread = new Thread(this);

    public SelfManaged(){
        thread.start();     //avoid start the thread in the constructor
    }

    public String toString(){
        return Thread.currentThread().getName() + "(" + countDown + ")";
    }

    @Override
    public void run() {
        while(true){
            System.out.println(this);
            if (--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0; i< 5; i++){
            new SelfManaged();
        }
    }
}
