package com.sunyee.javacore.base.concurrent;

import java.util.concurrent.*;

/**
 * Created by lishunyi on 2019/7/25
 */
public class Memoizer4<A, V> implements Computable<A, V> {

    private final ConcurrentHashMap<A, FutureTask<V>> cache = new ConcurrentHashMap<>();
    private Computable<A, V> c;
    private Memoizer4(Computable<A, V> c){
        this.c = c;
    }
    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        while(true){
            FutureTask<V> result = cache.get(arg);
            if (result == null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(eval);
                result = cache.putIfAbsent(arg, ft);
                if (result == null){
                    result = ft;
                    ft.run();
                }

            }
            try {
                return result.get();
            } catch (CancellationException e){
                //计算取消是移除该FutureTask
                cache.remove(arg);
            }
        }
    }
}
