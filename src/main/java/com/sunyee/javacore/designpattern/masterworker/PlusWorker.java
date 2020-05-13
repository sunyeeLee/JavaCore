package com.sunyee.javacore.designpattern.masterworker;

/**
 * 计算1～100的立方和
 * Created by lishunyi on 2019/8/6
 */
public class PlusWorker extends Worker{

    @Override
    public Object handle(Object input){
        Integer i = (Integer) input;
        return i * i * i;
    }
}
