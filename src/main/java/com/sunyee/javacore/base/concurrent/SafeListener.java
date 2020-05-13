package com.sunyee.javacore.base.concurrent;

import java.awt.*;
import java.util.EventListener;

/**
 * 如果想在构造函数中注册一个事件监听器或启动线程，那么可以使用一个私有的构造函数和一个公共的静态工厂方法。
 * 不在构造函数中启动线程是因为避免逸出
 * Created by lishunyi on 2019/7/23
 */
public class SafeListener {

    private final EventListener eventListener;

    private SafeListener(){
        eventListener = new EventListener() {
            public void onEvent(Event event){
                //do something
            }
        };
    }

    public static SafeListener newInstance(EventSource source){
        SafeListener safeListener = new SafeListener();
        source.registerListener(safeListener.eventListener);
        return safeListener;
    }
}


class EventSource{

    public void registerListener(EventListener eventListener){
        //do something
    }
}