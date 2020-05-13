package com.sunyee.javacore.base.concurrent.thinking_in_java;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lishunyi on 2020/4/21
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger ai = new AtomicInteger(0);
    @Override
    public int next() {
        return ai.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
