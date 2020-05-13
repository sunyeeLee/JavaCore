package com.sunyee.javacore.designpattern.adaptor.biz;

/**
 *  这个模块定义的接口和底层定义的接口不兼容，无法将底层的UserInfo 实现类直接拿来使用，
 *  现在要在这两个接口之间架起一道桥梁，使我们可以是两个模块兼容起来，所以，我们构造一个适配器，
 *  这个适配器要能完成 UserInformation 定义的功能:
 * Created by lishunyi on 2019/8/29
 */
public class UserInformationAdaptor implements UserInformationFromSystemB {

    private UserInfoFromSystemA userInfoFromSystemA;

    @Override
    public String getUserName() {
        return userInfoFromSystemA.getUserName();
    }

    @Override
    public String getUserId() {
        return userInfoFromSystemA.getUserId();
    }

    @Override
    public Integer getUserAge() {
        return userInfoFromSystemA.getUserAge();
    }

    @Override
    public String getUserAddress() {
        return userInfoFromSystemA.getUserProvince() + userInfoFromSystemA.getUserCity() + userInfoFromSystemA.getUserStreet();
    }
}
