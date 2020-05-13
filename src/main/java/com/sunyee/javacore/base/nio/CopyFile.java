package com.sunyee.javacore.base.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * 文件拷贝
 * Created by lishunyi on 2019/6/26
 */
public class CopyFile {

    public static void copyFileOfNIO(String resource, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        Channel readChannel = fis.getChannel();
        Channel writeChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            buffer.clear();
            int len = ((FileChannel) readChannel).read(buffer);
            if (len == -1){
                break;
            }
            //将position置零，同时将limit设置为capacity的大小，并清除了标志mark
            //通常用于读写转换的地方
            buffer.flip();
            ((FileChannel) writeChannel).write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }

    public static void main(String[] args) throws IOException {
        String resourcePath = "/Users/lishunyi/ToTheFuture/DeepLearning/TensorflowGoogle深度学习框架.pdf";
        String destination = "/Users/lishunyi/ToTheFuture/DeepLearning/TensorflowGoogle深度学习框架1.pdf";
        copyFileOfNIO(resourcePath, destination);
    }
}
