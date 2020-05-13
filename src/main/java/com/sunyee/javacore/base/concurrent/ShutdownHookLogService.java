package com.sunyee.javacore.base.concurrent;

/**
 * 关闭钩子
 * Created by lishunyi on 2019/7/26
 */
public class ShutdownHookLogService {

    public void start(){
        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run(){
                try{
                    ShutdownHookLogService.this.stop();
                } catch (InterruptedException ignored){

                }
            }
        });
    }

    public void stop() throws InterruptedException{
        //
    }
}
