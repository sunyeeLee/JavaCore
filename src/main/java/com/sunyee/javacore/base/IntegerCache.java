package com.sunyee.javacore.base;

/**
 * Differences between new Integer(127), Integer.valueOf(127) and just 127.
 * new Integer(127) 与 Integer.valueOf(127) 的区别在于：
 *
 * new Integer(127) 每次都会新建一个对象；
 * Integer.valueOf(127) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。
 * Created by lishunyi on 2019/5/20
 */
public class IntegerCache {
    public static void main(String[] args) {
        Integer a = new Integer(127);
        Integer b = new Integer(127);
        Integer c = 127; //auto boxing
        //编译器会在自动装箱过程调用 valueOf() 方法，因此多个值相同且值在缓存池范围内的 Integer
        // 实例使用自动装箱来创建，那么就会引用相同的对象。
        Integer d = Integer.valueOf(127);
        Integer e = 127;
        System.out.println(a == b); //false
        System.out.println(a == c); //false
        System.out.println(a == d); //false
        System.out.println(c == d); //true
        System.out.println(c == e); //true
    }
}
