package com.sunyee.javacore.base.concurrent;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 利用同步机制构建缓存用以存储耗时久的计算结果.
 *
 * 该实现对整个compute方法进行同步。虽然能保证线程的安全性，但是会带来一种明显的可伸缩性问题：
 * 每次只有一个线程能够执行compute()方法，其他线程会被阻塞很长时间
 * Created by lishunyi on 2019/7/25
 */
public class Memoizer1<A, V> implements Computable<A, V>{

    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c){
        this.c = c;
    }
    @Override
    public synchronized V compute(A arg) throws InterruptedException, ExecutionException {
        V result = cache.get(arg);

        if (result == null){
            result = this.c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
