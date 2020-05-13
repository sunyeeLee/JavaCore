package com.sunyee.javacore.designpattern.masterworker;

import java.util.Map;
import java.util.Queue;

/**
 * Worker进程， 负责执行具体的任务
 * Created by lishunyi on 2019/8/6
 */
public class Worker implements Runnable {

    //任务队列， 用于获取任务
    private Queue<Object> workQueue;

    //子任务结果处理集
    private Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue){
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap){
        this.resultMap = resultMap;
    }

    //子任务处理的逻辑，在子类中实现具体逻辑
    public Object handle(Object input){
        return input;
    }

    @Override
    public void run() {
        while(true){
            Object input = workQueue.poll();
            if (input == null){
                break;
            }
            //处理子任务
            Object result = handle(input);
            //将结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()), result);
        }
    }
}
