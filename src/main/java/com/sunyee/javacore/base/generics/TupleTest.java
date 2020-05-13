package com.sunyee.javacore.base.generics;

/**
 * 元组测试
 * Created by lishunyi on 2020/4/9
 */


class TwoTuple<A, B>{
    public final A a;
    public final B b;

    public TwoTuple(A a, B b){
        this.a = a ;
        this.b = b;
    }

    @Override
    public String toString(){
        return "(" + a + b + ")";
    }
}

class ThirdTuple<A, B, C> extends TwoTuple<A, B>{
    public final C c;

    public ThirdTuple(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String toString(){
        return "(" + a + b + c + ")";
    }
}
public class TupleTest {

    public static void main(String[] args) {
        TwoTuple<String, Integer> twoTuple = new TwoTuple<>("sunyee", 24);
        ThirdTuple<String, Integer, String> thirdTuple = new ThirdTuple<>("sunyee", 24, "男");
        System.out.println(twoTuple);
        System.out.println(thirdTuple);
    }
}
