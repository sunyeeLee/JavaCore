package com.sunyee.javacore.designpattern.adaptor.power;

/**
 * Created by lishunyi on 2019/8/29
 */
public interface AbstractNationalPower {

    /**
     * 国家电网， 提供交流电接口
     * @return
     */
    String provideAlternatableCurrent();
}
