package com.sunyee.javacore.base.concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Vector;

/**
 * Created by lishunyi on 2019/7/23
 */
@ThreadSafe
public class BetterVector<E>  extends Vector<E> {

    /**
     * 在vector的基础上新增 " 若没有则添加 "的方法
     * @param x elements to be add in vector
     * @return add element success or not
     */
    public synchronized boolean putIfAbsent(E x){
        boolean absent = this.contains(x);
        if (!absent){
            this.add(x);
        }
        return absent;
    }
}
