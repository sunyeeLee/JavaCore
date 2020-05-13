package com.sunyee.javacore.designpattern.decorator;

/**
 * 装饰器模式：
 * 1。给对象动态地添加附加功能。
 * 2。装饰者提供了一个灵活的拓展子类功能的备选方案。
 * 3。防止子类爆炸
 *
 *
 * Component :定义了一个可以被动态添加功能的接口
 * Decorator :持有一个Component对象的引用，并且定义了一个和Component保持一致的接口。
 * ConcreteDecorator :为Component添加功能的角色。
 *
 * Created by lishunyi on 2019/8/29
 */
public class Client {

    public static void main(String[] args) {
        Singer singer = new Singer();
        SingerDecorator decorator = new SingerDecoratorC(new SingerDecoratorB(new SingerDecoratorA(singer)));
        decorator.sing();

    }
}
