package com.sunyee.javacore.designpattern.singleton;

/**
 * 饿汉模式
 * 由私有构造方法和static来确定唯一性。
 * 缺点：何时产生实例 不好控制, 在类Singleton第一次被加载的时候，就产生了一个实例。
 * Created by lishunyi on 2019/2/25
 */
public class HungrySingleton {

    private HungrySingleton(){
        System.out.println("hungry singleton");
    }

    private static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return singleton;
    }

    //缺点：System.out.println(Singleton.STATUS);
//    这个实例就被产生了。也许此时你并不希望产生这个实例。
//    如果系统特别在意这个问题，这种单例的实现方法就不太好。

    public static class BadOfHungrySingleton{
        public static Integer status = 1;

        private BadOfHungrySingleton(){
            System.out.println("bad of hungry singleton");
        }

        private static BadOfHungrySingleton badOfHungrySingleton = new BadOfHungrySingleton();

        public static BadOfHungrySingleton getInstance(){
            return badOfHungrySingleton;
        }

    }
}
