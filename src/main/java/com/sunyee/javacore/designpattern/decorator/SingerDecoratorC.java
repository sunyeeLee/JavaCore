package com.sunyee.javacore.designpattern.decorator;

/**
 * Created by lishunyi on 2019/8/29
 */
public class SingerDecoratorC extends SingerDecorator {

    public SingerDecoratorC(Singer singer) {
        super(singer);
    }

    @Override
    public void sing() {
        super.sing();
        this.introduceBackground();
    }

    private void introduceBackground(){
        System.out.println("悲惨背景介绍，博取同情，赢感情牌....");
    }
}
