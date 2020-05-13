package com.sunyee.javacore.designpattern.decorator;

/**
 * Created by lishunyi on 2019/8/29
 */
public class SingerDecoratorA extends SingerDecorator {

    public SingerDecoratorA(Singer singer) {
        super(singer);
    }

    public void sing(){
        this.dance();
        super.sing();
    }

    private void dance(){
        System.out.println("翩翩起舞");
    }
}
