package com.sunyee.javacore.designpattern.proxy.staticproxy;

/**
 * 该接口定义了售票服务，主题接口。
 * Created by lishunyi on 2019/7/30
 */
public interface ITicketService {

    /**
     * 查询票务信息
     */
    void inquire();

    /**
     * 售卖
     */
    void sell();

    /**
     * 退票
     */
    void returnTicket();
}
