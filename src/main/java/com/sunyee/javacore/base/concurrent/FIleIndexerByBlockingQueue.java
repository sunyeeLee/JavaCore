package com.sunyee.javacore.base.concurrent;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lishunyi on 2019/7/24
 */
public class FIleIndexerByBlockingQueue implements Runnable {

    private final BlockingQueue<File> fileQueue;

    public FIleIndexerByBlockingQueue(BlockingQueue<File> fileQueue){
        this.fileQueue = fileQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                indexFile(fileQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void indexFile(File file){
        System.out.println("file: " + file.getAbsolutePath() + file.getName());
    }
}
