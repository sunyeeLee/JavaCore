package com.sunyee.javacore.designpattern.singleton;

/**
 * 让instance只有在调用getInstance()方式时被创建，并且通过synchronized来确保线程安全。
 * 这样就控制了何时创建实例。
 *
 * 这种方法是延迟加载的典型。
 *
 * 但是有一个问题就是，在高并发的场景下性能会有影响，虽然只有一个判断就return了，但是在并发量很高的情况下，或多或少都会有点影响，因为都要去拿synchronized的锁。
 * Created by lishunyi on 2019/2/25
 */
public class LazySingleton {

    private LazySingleton(){
        System.out.println("lazy singleton");
    }

    private static LazySingleton singleton = null;

    public synchronized static LazySingleton getInstance(){
        if (singleton == null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}

/**
 * 双重检验单例模式
 */
class DoubleLockSingleton{

    private DoubleLockSingleton(){
        System.out.println("double lock singleton");
    }

    private volatile static DoubleLockSingleton singleton = null;

    public static DoubleLockSingleton getInstance(){
        if (singleton == null){
            synchronized (DoubleLockSingleton.class){
                if (singleton == null){
                    singleton = new DoubleLockSingleton();
                }
            }
        }
        return singleton;
    }
}