package com.sunyee.javacore.base.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Memoizer3的实现几乎是完美的：他表现出了非常好的并发(基本上是源于ConcurrentHashMap高效的并发性),若结果计算出来，那么将立即返回。
 * 如果其他线程正在计算该结果，那么新到的线程会等待该结果计算出来。然后它仍然存在一个缺陷，即仍然存在两个线程计算相同值的漏洞。
 * 这个漏洞发生的概率会远远小于Memoizer2中发生的概率。但是因为compute()方法中的if代码块仍然不是原子（nonatomic）的，因此
 * 仍然存在两个线程同时调用compute计算相同值的漏洞。
 *
 * 解决方案，使用复合操作("若没有则添加--》putIfAbsent"),详见Memoizer4.class
 * Created by lishunyi on 2019/7/25
 */
public class Memoizer3<A, V> implements Computable<A, V> {

    private final Map<A, FutureTask<V>> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c){
        this.c = c;
    }
    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        FutureTask<V> result = cache.get(arg);
        if (result == null){
            Callable eval = new Callable() {
                @Override
                public Object call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<>(eval);
            result = ft;
            cache.put(arg, result);
            ft.run();   //在这里将调用c.compute()
        }

        return result.get();
    }
}
