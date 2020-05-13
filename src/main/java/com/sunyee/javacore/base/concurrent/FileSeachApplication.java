package com.sunyee.javacore.base.concurrent;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 桌面搜索应用程序
 * Created by lishunyi on 2019/7/24
 */
public class FileSeachApplication {

    public static void main(String[] args) {
        BlockingQueue<File> queue = new LinkedBlockingDeque();
        File root = new File("/Users/lishunyi/ToTheFuture");
        FileCrawlerByBlockingQueue crawler = new FileCrawlerByBlockingQueue(queue, root);
        FIleIndexerByBlockingQueue indexer = new FIleIndexerByBlockingQueue(queue);
        Thread crawlThread = new Thread(crawler);
        Thread indexThread = new Thread(indexer);
        crawlThread.start();
        indexThread.start();
    }
}
