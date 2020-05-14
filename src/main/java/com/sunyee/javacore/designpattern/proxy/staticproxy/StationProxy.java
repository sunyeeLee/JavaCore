package com.sunyee.javacore.designpattern.proxy.staticproxy;

/**
 * 车票代售点. 代理类
 * Created by lishunyi on 2019/7/30
 */
public class StationProxy implements ITicketService {

    private Station station;

    public StationProxy(Station station){
        this.station = station;
    }


    @Override
    public void inquire() {
        //1. 真实业务前， 提示信息
        this.showAllertInfo("*****欢迎光临本代售点。查询票务信息不会收费*****");
        //2. 调用真实业务逻辑
        station.inquire();
        //3.后处理
        this.showAllertInfo("*****欢迎您的光临，再见！********");
    }

    @Override
    public void sell() {
        //1.真实业务前， 提示信息
        this.showAllertInfo("*****您正在车票代售点进行购票，每张票将会收取5元手续费!!!****");
        //2.调用真实业务逻辑
        station.sell();
        //3.后处理
<<<<<<< HEAD
        this.takeHandlingFee();    //扣除手续费用
=======
        this.takeHandleingFee();    //扣除手续费用
>>>>>>> 69e81ebaf5f10d2f02c787dc6e09a6368fd24275
        this.showAllertInfo("*****购票成功！*********");
    }

    @Override
    public void returnTicket() {
        //1.真实业务前，提示信息
        this.showAllertInfo("*****欢迎光临本售票点，退票除了扣除20%费用，还需要收取2元额外手续费！***");
        //2.真实业务逻辑
        station.returnTicket();
        //3.后处理
<<<<<<< HEAD
        this.takeHandlingFee();    //扣除费用
=======
        this.takeHandleingFee();    //扣除费用
>>>>>>> 69e81ebaf5f10d2f02c787dc6e09a6368fd24275
        this.showAllertInfo("*****期待下次为您服务！******");
    }

    /**
     * 展示额外信息
     * @param info
     */
    private void showAllertInfo(String info){
        System.out.println(info);
    }

    /**
     * 收取手续费
     */
<<<<<<< HEAD
    private void takeHandlingFee(){
=======
    private void takeHandleingFee(){
>>>>>>> 69e81ebaf5f10d2f02c787dc6e09a6368fd24275
        System.out.println("手续手续费，打印发票...........\n");
    }
}
