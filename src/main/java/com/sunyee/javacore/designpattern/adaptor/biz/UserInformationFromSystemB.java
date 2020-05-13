package com.sunyee.javacore.designpattern.adaptor.biz;

/**
 * Created by lishunyi on 2019/8/29
 */
public interface UserInformationFromSystemB {

    String getUserName();

    String getUserId();

    Integer getUserAge();
    //UserAddredss = province + city + street;
    String getUserAddress();
}
