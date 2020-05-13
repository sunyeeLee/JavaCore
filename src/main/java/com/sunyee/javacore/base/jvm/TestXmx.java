package com.sunyee.javacore.base.jvm;

import java.util.Vector;

/**
 * -Xmx参数设置最大堆内存，他是新生代和老年代内存之和。
 *
 */
public class TestXmx {

    public static void main(String[] args) {
        Vector<byte[]> vector = new Vector<>();
        for (int i=0; i<5; i++){
            byte[] b = new byte[1024 * 1024];
            vector.add(b);
            System.out.println(i + " M is allocated.");
        }
        System.out.println("max memory: " + Runtime.getRuntime().maxMemory()/1024/1024 +"M");
    }
}
