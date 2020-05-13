package com.sunyee.javacore.designpattern.adaptor.biz;

/**
 * A系统的底层提供的用户信息接口
 * Created by lishunyi on 2019/8/29
 */
public interface UserInfoFromSystemA {

    String getUserName();

    String getUserId();

    Integer getUserAge();

    String getUserProvince();

    String getUserCity();

    String getUserStreet();
}
