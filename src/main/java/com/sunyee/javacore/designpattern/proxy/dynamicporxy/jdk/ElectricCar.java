package com.sunyee.javacore.designpattern.proxy.dynamicporxy.jdk;

/**
 * 电能车类
 * Created by lishunyi on 2019/7/30
 */
public class ElectricCar implements Vehicle, Recharhable{
    @Override
    public void recharge() {
        System.out.println("***ElectricCar is recharging!!!***");
    }

    @Override
    public void drive() {
        System.out.println("***ElectricCar is Moving!!!****");
    }
}
