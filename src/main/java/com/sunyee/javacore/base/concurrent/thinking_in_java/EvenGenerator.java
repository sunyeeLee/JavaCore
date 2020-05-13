package com.sunyee.javacore.base.concurrent.thinking_in_java;

/**
 * 一个任务有可能在另一个任务执行++currentEventValue(第一个)，且没开始执行第二个的操作之前，调用了next()方法。
 * 这种情况将导致currentEventValue处于"不恰当"的状态。如EvenGenerator.test()执行结果所示。
 *
 * 这种情况的原因： 共享资源竞争。
 * Created by lishunyi on 2020/4/17
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * IntGenerator抽象类，包含EvenChecker必不可缺的方法，一个next()方法，和一个可以撤销的方法
 */
abstract class IntGenerator{
    private volatile boolean canceled =false;   //volatile保证可见性

    public abstract  int next();

    //allow this to be canceled
    public void cancle(){
        canceled = true;
    }

    public boolean isCancled() {
        return canceled;
    }
}


class EvenChecker implements Runnable{

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator generator, int ident){
        this.generator = generator;
        id = ident;
    }
    @Override
    public void run() {
        while (!generator.isCancled()){
            int value = generator.next();
            if (value % 2 !=0){
                System.out.println(value + " not even number!");
                generator.cancle();
            }
        }
    }

    /**
     * test any type of IntGenerator
     * @param generator
     * @param count
     */
    public static void test(IntGenerator generator, int count) {
        if (generator == null || count<=0){
            throw new RuntimeException("args error!!!");
        }
        System.out.println("press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i< count; i++){
            executorService.execute(new EvenChecker(generator, i));
        }
        executorService.shutdown();
    }

    //default value for count
    public static void test(IntGenerator generator){
        test(generator, 10);
    }


}


public class EvenGenerator extends IntGenerator{

    private int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;    //danger point here
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}


class SynchronizedEventGenerator extends IntGenerator{

    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        // 对Thread.yield()的调用插入到2个递增操作之间，以提高在currentEventValue是奇数状态时上下文切换的可能性。
        // 因为互斥可以防止多个任务同时进入临界区。所以不会产生失败，但是如果失败将发生， 调用yield()是一种促使其发生的
        // 有效方式
//        Thread.yield(); // cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }
}


class MutexEvenGenerator extends IntGenerator{

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        try {
            lock.lock();
            ++currentEvenValue;
            Thread.yield(); // cause failure faster
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }
}
