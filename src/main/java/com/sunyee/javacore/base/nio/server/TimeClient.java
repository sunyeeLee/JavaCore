package com.sunyee.javacore.base.nio.server;

/**
 * 时间服务器客户端
 * Created by lishunyi on 2019/9/3
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e){
                port = 8080;
            }
        }
        new Thread(new TimeClientHandle("127.0.0.1", port), "Time_Client_001").start();
        }


}
