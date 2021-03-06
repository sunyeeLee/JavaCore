package com.sunyee.javacore.base.concurrent.thinking_in_java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lishunyi on 2020/4/16
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<5; i++){
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
