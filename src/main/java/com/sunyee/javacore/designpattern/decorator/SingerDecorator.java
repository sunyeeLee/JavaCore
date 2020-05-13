package com.sunyee.javacore.designpattern.decorator;

/**
 * 主题修饰类
 * Created by lishunyi on 2019/8/29
 */
public class SingerDecorator extends Singer {
    private Singer singer;

    public SingerDecorator(Singer singer){
        this.singer = singer;
    }
    @Override
    public void sing() {
        singer.sing();
    }
}
