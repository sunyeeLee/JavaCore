package com.sunyee.javacore.base.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分而治之思想
 *
 * fork/join类似MapReduce算法，两者区别是：Fork/Join 只有在必要时如任务非常大的情况下才分割成一个个小任务，
 * 而 MapReduce总是在开始执行第一步进行分割。看来，Fork/Join更适合一个JVM内线程级别，而MapReduce适合分布式系统。
 * Created by lishunyi on 2020/4/26
 */
public class CountTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10000;

    private Long start;
    private Long end;

    public CountTask(Long start, Long end){
        super();
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute){
            for (long i = start; i <= end; i++){
                sum = sum + i;
            }
        } else {
            //分成100个小任务
            long step = (start + end) / 100;
            List<CountTask> countTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0 ; i < 100; i++){
                long lastOne = pos + step;
                if (lastOne > end){
                    lastOne = end;
                }
                CountTask task = new CountTask(pos, lastOne);
                pos += step + 1;
                countTasks.add(task);
                task.fork();    //子任务放进线程池
            }
            for (CountTask task: countTasks){
                sum += task.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0L, 20000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long sum = result.get();
            System.out.println("sum: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
