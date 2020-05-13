package com.sunyee.javacore.base.concurrent;

import java.math.BigInteger;

/**
 * Created by lishunyi on 2019/7/25
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
