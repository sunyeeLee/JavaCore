package com.sunyee.javacore.designpattern.adaptor.power;

/**
 * 适配器模式在于，adaptee在系统中的不可代替性，一般为模块的底层或者是基础部分，当遇到不兼容的情况时，
 * 不方便或者对于当前系统稳定性和拓展性的考虑，应当遵循 “对修改关闭，对拓展开放”的原则，使用适配器模式可以很好地满足这一点。
 * Created by lishunyi on 2019/8/29
 */
public class Client {
    public static void main(String[] args) {
        AbstractNationalPower nationalPower = new ChineseNationalPower();
        AbstractComputerPower computerPower = new ComputerPowerAdaptor(nationalPower);
        System.out.println(computerPower.provideDirectCurrent());
    }
}
