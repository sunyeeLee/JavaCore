package com.sunyee.javacore.designpattern.proxy.staticproxy;

/**
 * 车站类。真实主题
 * Created by lishunyi on 2019/7/30
 */
public class Station implements ITicketService{
    @Override
    public void inquire() {
        System.out.println("\n\t查询.........\n");
    }

    @Override
    public void sell() {
        System.out.println("\n\t售票.........\n");
    }

    @Override
    public void returnTicket() {
        System.out.println("\n\t退票.........\n");
    }
}
