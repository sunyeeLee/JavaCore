package com.sunyee.javacore.designpattern.immutable;

import javax.annotation.concurrent.Immutable;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 不可变容器类
 * 可以返回新的容器对象，这样的话其他线程仍然会看到对象一致的情况。
 * 如果在构造函数、getFactors()中没有使用新的容器对象，那么OneValueCache仍然不是不可变的.
 * Created by lishunyi on 2019/7/23
 */
@Immutable
public final class OnevalueCache {
    private final BigInteger lastNumbers;

    private final BigInteger[] lastFactors;


    public OnevalueCache(BigInteger lastNumbers, BigInteger[] lastFactors){
        this.lastNumbers = lastNumbers;
        this.lastFactors = Arrays.copyOf(lastFactors, lastFactors.length);
    }

    public BigInteger[] getFactors(BigInteger i){
        if (lastNumbers == null || !lastNumbers.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }
}
