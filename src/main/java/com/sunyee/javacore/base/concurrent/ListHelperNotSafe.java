package com.sunyee.javacore.base.concurrent;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 非线程安全的ListHelper, 虽然加锁，但只是带来了同步的假象。因为使用了不同的锁，因此对于list来说，该方法就不是线程安全的了。
 * Created by lishunyi on 2019/7/23
 */
@NotThreadSafe
public class ListHelperNotSafe<E> {

    private List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E x){
        boolean absent = list.contains(x);
        if (!absent){
            list.add(x);
        }
        return absent;
    }
}
