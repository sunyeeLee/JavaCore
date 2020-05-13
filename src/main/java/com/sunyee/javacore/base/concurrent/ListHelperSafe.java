package com.sunyee.javacore.base.concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 线程安全的容器类
 * Created by lishunyi on 2019/7/23
 */
@ThreadSafe
public class ListHelperSafe<E> {

    private List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E x){
        synchronized (list){
            boolean absent = list.contains(x);
            if (!absent){
                list.add(x);
            }
            return absent;
        }
    }
}
