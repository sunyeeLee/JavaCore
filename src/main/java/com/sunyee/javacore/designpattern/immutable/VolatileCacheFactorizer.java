package com.sunyee.javacore.designpattern.immutable;

import javax.annotation.concurrent.ThreadSafe;
import java.math.BigInteger;

/**
 * Created by lishunyi on 2019/7/23
 */
@ThreadSafe
public class VolatileCacheFactorizer {

    private volatile OnevalueCache cache = new OnevalueCache(null, null);

    public void service(BigInteger i) {
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null){
            factors = factor(i);
            cache = new OnevalueCache(i, factors);
        }
    }

    /**
     * return factors
     * @return
     */
    private BigInteger[] factor(BigInteger i){
        return new BigInteger[]{i};
    }
}
