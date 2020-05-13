package com.sunyee.javacore.designpattern.adaptor.biz;

/**
 * Created by lishunyi on 2019/8/29
 */
public class UserInfoFromSystemAImpl implements UserInfoFromSystemA {

    private UserInfoPO userInfo = new UserInfoPO();

    @Override
    public String getUserName() {
        return userInfo.getName();
    }

    @Override
    public String getUserId() {
        return userInfo.getId();
    }

    @Override
    public Integer getUserAge() {
        return userInfo.getAge();
    }

    @Override
    public String getUserProvince() {
        return userInfo.getProvince();
    }

    @Override
    public String getUserCity() {
        return userInfo.getCity();
    }

    @Override
    public String getUserStreet() {
        return userInfo.getStreet();
    }
}
