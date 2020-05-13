package com.sunyee.javacore.base.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒数计时器
 * 一种典型的场景就是火箭发射。在火箭发射前，为了保证万无一失，往往还要进行各项设备、仪器的检查。
 * 只有等所有检查完毕后，引擎才能点火。这种场景就非常适合使用CountDownLatch。它可以使得点火线程
 * ，等待所有检查线程全部完工后，再执行
 * Created by lishunyi on 2019/6/25
 */
public class CountDownLatchTest implements Runnable{

    private static final CountDownLatch countDownLatch = new CountDownLatch(10);

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " complete");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest test = new CountDownLatchTest();
        ExecutorService executorService =Executors.newFixedThreadPool(10);
        for (int i=0; i< 10; i++){
            executorService.submit(test);
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
