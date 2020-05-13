package com.sunyee.javacore.designpattern.masterworker;

import java.util.Map;
import java.util.Set;

/**
 * 利用master-worker模式并行计算1^3 + 2^3 + .... + 100^3
 *
 * 其中Master负责任务分发以及维护Worker进程
 * 多个Worker进程协作处理用户请求
 * Created by lishunyi on 2019/8/6
 */
public class Main {
    public static void main(String[] args) {
        //初始化Master进程， 并指定5个worker进程
        Master master = new Master(new PlusWorker(), 5);

        //指定100个子任务
        for (int i= 1; i <= 100; i++){
            master.submit(i);
        }
        //开始计算
        master.execute();

        int re = 0; //最终结果

        Map<String, Object> resultMap = master.getResultMap();

        while(resultMap.size() > 0 || !master.isCompleted()){
            //不需要等待所有worker执行完，即可开始计算最终结果
            Set<String> keys = resultMap.keySet();

            String key = null;

            for (String k : keys){
                key = k;
                break;
            }
            Integer i = null;
            if (key !=null){
                i = (Integer) resultMap.get(key);
            }

            if (i != null){
                re += i;        //最终结果
            }

            if (key != null){
                resultMap.remove(key);  //移除已经被计算过的项
            }
        }

        System.out.println("result: " + re);
    }
}
