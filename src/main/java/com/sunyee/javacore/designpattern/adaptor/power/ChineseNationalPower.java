package com.sunyee.javacore.designpattern.adaptor.power;

/**
 * Created by lishunyi on 2019/8/29
 */
public class ChineseNationalPower implements AbstractNationalPower {

    @Override
    public String provideAlternatableCurrent() {
        return "220V 交流电";
    }
}
