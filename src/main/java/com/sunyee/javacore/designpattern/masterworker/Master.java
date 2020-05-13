package com.sunyee.javacore.designpattern.masterworker;


import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by lishunyi on 2019/8/6
 */
public class Master {

    //任务队列
    private Queue<Object> workQueue = new ConcurrentLinkedQueue<>();

    //Worker进程队列
    private Map<String, Thread> threadMap = new HashMap<>();

    //子任务结果处理集
    private Map<String, Object> resultMap = new ConcurrentHashMap<>();


    public Master(Worker worker, int workerCount){
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i< workerCount; i++){
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    /**
     * 是否所有的任务都已完成
     * @return all works done -> true , otherwise -> false
     */
    public boolean isCompleted(){
        for (Map.Entry<String, Thread> entry: threadMap.entrySet()){
            if (entry.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }


    /**
     * 提交一个任务
     * @param obj
     */
    public void submit(Object obj){
        workQueue.add(obj);
    }

    /**
     * 返回结果集
     * @return
     */
    public Map<String, Object> getResultMap(){
        return resultMap;
    }

    /**
     * 执行所有的worker进程
     */
    public void execute(){
        for (Map.Entry<String, Thread> entry: threadMap.entrySet()){
            entry.getValue().start();
        }
    }

}
