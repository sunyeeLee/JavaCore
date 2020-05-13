package com.sunyee.javacore.designpattern.singleton;

/**
 * 由于加载一个类时，其内部类不会被加载。这样保证了只有调用getInstance()时才会产生实例，控制了生成实例的时间，实现了延迟加载。
 * 并且去掉了synchronized，让性能更优，用static来确保唯一性。
 * Created by lishunyi on 2019/2/25
 */
public class InnerClassSingleton {
    private InnerClassSingleton(){
        System.out.println("inner class singleton");
    }

    private static class SingletonHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        InnerClassSingleton i1 = InnerClassSingleton.getInstance();
        InnerClassSingleton i2 = InnerClassSingleton.getInstance();
        System.out.println(i1 == i2);
    }

}
