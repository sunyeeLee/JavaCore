package com.sunyee.javacore.base.concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * 使用Semaphore来控制任务的提交速率
 * Created by lishunyi on 2019/7/26
 */
@ThreadSafe
public class BoundExecutor {

    private final Executor executor;

    private final Semaphore semaphore;


    public BoundExecutor(Executor executor, int bound){
        this.executor = executor;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();

        try{
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        executor.execute(command);
                    } finally {
                        semaphore.release();
                    }
                }
            });
        } catch (RejectedExecutionException e){
            semaphore.release();
        }
    }

}
