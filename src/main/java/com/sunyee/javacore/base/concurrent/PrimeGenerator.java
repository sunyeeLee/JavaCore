package com.sunyee.javacore.base.concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 素数生成器，可中断
 * Created by lishunyi on 2019/7/25
 */
@ThreadSafe
public class PrimeGenerator implements Runnable{

    public static void main(String[] args) {
        aSecondOfPrime().forEach(System.out::println);
    }
    private final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled){
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }

        }

    }

    public void stop(){
        cancelled = true;
    }

    public List<BigInteger> get(){
        return new ArrayList<>(primes);
    }

    public static List<BigInteger> aSecondOfPrime() {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            generator.stop();
        }
        return generator.get();
    }
}
