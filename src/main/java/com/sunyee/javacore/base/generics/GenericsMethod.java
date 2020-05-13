package com.sunyee.javacore.base.generics;

/**
 * Created by lishunyi on 2020/4/9
 */
public class GenericsMethod {

    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericsMethod genericsMethod = new GenericsMethod();
        genericsMethod.f("");
        genericsMethod.f(1);
        genericsMethod.f(1L);
        genericsMethod.f(1D);
    }
}
