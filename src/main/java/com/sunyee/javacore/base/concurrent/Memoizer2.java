package com.sunyee.javacore.base.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * 利用线程安全的map来构建缓存。
 *
 * Memoizer2比Memoizer1有着更好的并发行为：多线程可以并发地使用他。但是他仍然存在着一些不足-当两个线程同时调用compute时会存在一个漏洞，
 * 可能会导致计算相同的值。使用时，这只会带来低效。因为缓存的作用正是避免相同的数据被计算多次。
 *
 * 问题分析：
 *      Memoizer2的问题在于：如果某个线程启动了一个开销很大的计算，而其他线程并不知道这个计算正在"进行中"，那么很可能会重复这个计算。因此我们
 * 需要某种机制，来表达当" A线程正在计算f(27)时 "， 这时当另一个线程B查找f(27)，B知道最高效的方法是等待线程A计算结束，然后再去缓存中查询。
 * 因此，我们可以引入Future模式。而FutureTask工具类可以实现。FutureTask表示一个计算的过程，这个过程可能已经计算完成，也可能正在进行。如果有
 * 结果可用，那么FutureTask.get将立即返回结果，否则将会一直阻塞，直到结果计算出来再将其返回.
 * Created by lishunyi on 2019/7/25
 */
public class Memoizer2<A, V> implements Computable<A, V>{

    private final Map<A, V> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;


    public Memoizer2(Computable<A, V> c){
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        V result = cache.get(arg);
        if (result == null){
            result = this.c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
