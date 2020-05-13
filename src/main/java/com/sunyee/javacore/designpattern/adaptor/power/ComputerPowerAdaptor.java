package com.sunyee.javacore.designpattern.adaptor.power;

/**
 * Created by lishunyi on 2019/8/29
 */
public class ComputerPowerAdaptor implements AbstractComputerPower{

    private AbstractNationalPower nationalPower;

    public ComputerPowerAdaptor(AbstractNationalPower nationalPower){
        this.nationalPower = nationalPower;
    }

    @Override
    public String provideDirectCurrent() {
        String nationPower = nationalPower.provideAlternatableCurrent();
        return transform(nationPower);
    }

    private String transform(String nationPower){
        System.out.println("对交流电整流，变压，输出直流电");
        return "12V 直流电";
    }
}
