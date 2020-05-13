package com.sunyee.javacore.framework.spring.aop;

/**
 * Created by lishunyi on 2019/8/1
 */
public class RailwayStation implements ITicketService {

    @Override
    public void sell() {
        System.out.println("售票................");
    }

    @Override
    public void inquire() {
        System.out.println("查询票务信息.............");
    }

    @Override
    public void returnTicket() {
        System.out.println("退票................");
    }
}
