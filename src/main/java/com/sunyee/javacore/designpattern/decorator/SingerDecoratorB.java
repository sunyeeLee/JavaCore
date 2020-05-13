package com.sunyee.javacore.designpattern.decorator;

/**
 * Created by lishunyi on 2019/8/29
 */
public class SingerDecoratorB extends SingerDecorator {
    public SingerDecoratorB(Singer singer) {
        super(singer);
    }

    @Override
    public void sing() {
        this.music();
        super.sing();
    }

    private void music(){
        System.out.println("播放背景音乐");
    }
}
