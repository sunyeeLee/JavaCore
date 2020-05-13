package com.sunyee.javacore.designpattern.proxy.staticproxy;

/**
 * Created by lishunyi on 2019/7/30
 */
public class Test {

    public static void main(String[] args) {
        Station station = new Station();
        ITicketService ticketService = new StationProxy(station);
        ticketService.inquire();
        ticketService.sell();
        ticketService.returnTicket();
    }
}
