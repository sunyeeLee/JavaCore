package com.sunyee.javacore.base.nio;

import java.nio.ByteBuffer;

/**
 * Buffer核心：position、capacity、limit
 * Created by lishunyi on 2019/7/31
 */
public class Buffer {

    public static void main(String[] args) {
        ByteBuffer b = ByteBuffer.allocate(15); //15字节的缓冲区
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity());
        for (int i = 0; i<10;i++){
            b.put((byte) i);
        }
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity() + " position=" + b.position());
        b.flip();   //重置position，且limit变为position大小 。通常用于读写模式转换
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity() + " position=" + b.position());
        for (int i = 0; i<5; i++){
            b.put((byte) i);
        }
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity() + " position=" + b.position());
        b.flip();
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity() + " position=" + b.position());
    }
}
