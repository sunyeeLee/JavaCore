package com.sunyee.javacore.base.concurrent;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 素数生成器
 * Created by lishunyi on 2019/7/26
 */
public class PrimeGeneratorWithInterrupted extends Thread{

    private final BlockingQueue<BigInteger> primes;

    public PrimeGeneratorWithInterrupted(BlockingQueue<BigInteger> queue){
        primes = queue;
    }
    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while(true){
            if (!Thread.currentThread().isInterrupted()){
                try {
                    p = p.nextProbablePrime();
                    primes.put(p);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cancel(){
        interrupt();
    }
}
