package com.sunyee.javacore.base.concurrent.thinking_in_java;

import java.util.concurrent.ThreadFactory;

/**
 * Created by lishunyi on 2020/4/16
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
