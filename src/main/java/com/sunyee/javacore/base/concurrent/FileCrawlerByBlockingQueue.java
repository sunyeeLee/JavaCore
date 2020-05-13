package com.sunyee.javacore.base.concurrent;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lishunyi on 2019/7/24
 */
public class FileCrawlerByBlockingQueue implements Runnable{

    private final BlockingQueue<File> fileQueue;

    private final File root;

    public FileCrawlerByBlockingQueue(BlockingQueue<File> fileQueue, File root){
        this.fileQueue = fileQueue;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles();
        for (File entry: entries){
            if (entry.isDirectory()){
                crawl(entry);
            } else {
                fileQueue.put(entry);
            }
        }
    }
}
