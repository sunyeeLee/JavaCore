package com.sunyee.javacore.base.concurrent.thinking_in_java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lishunyi on 2020/4/16
 */

class TaskWithResult  implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
public class CallableDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i=0; i<10; i++){
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs: results){
            if (fs.isDone()) {
                System.out.println(fs.get());
            }
        }
    }
}
