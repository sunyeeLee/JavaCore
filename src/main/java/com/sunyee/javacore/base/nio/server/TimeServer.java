package com.sunyee.javacore.base.nio.server;

/**
 * 时间服务器
 * Created by lishunyi on 2019/9/3
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e){
                port = 8080;
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO_MultiplexerTimeServer_001").start();
    }
}
