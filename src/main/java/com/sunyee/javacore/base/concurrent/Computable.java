package com.sunyee.javacore.base.concurrent;

import java.util.concurrent.ExecutionException;

/**
 * Created by lishunyi on 2019/7/25
 */
public interface Computable<A, V> {

    V compute(A arg) throws InterruptedException, ExecutionException;
}