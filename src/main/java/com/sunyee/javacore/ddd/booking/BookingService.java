package com.sunyee.javacore.ddd.booking;

/**
 * 将货物(Cargo)与航程关联起来，记录两者的之间的联系.
 *
 * 因为允许可以退订，所以一般航程的容量可以超过10%。
 * Created by lishunyi on 2019/9/17
 */
public class BookingService {

    private OverBookingPolicy policy = new OverBookingPolicy();

    /**
     * 常见货物订单
     * @param voyage 航程
     * @param cargo 货物
     * @return 订单创建是否成功。1: success -1: fail
     */
    public int makeBooking(Voyage voyage, Cargo cargo){
        if (!policy.isAllowed(voyage, cargo)){
            return -1;
        }
        voyage.addCargo(cargo);
        return 1;
    }

    public static void main(String[] args) {
        Voyage voyage = new Voyage(100, "广州");
        Cargo cargo = new Cargo(20);
        Cargo cargo1 = new Cargo(30);
        Cargo cargo2 = new Cargo(30);
        Cargo cargo3 = new Cargo(30);
        BookingService bookingService = new BookingService();
        bookingService.makeBooking(voyage, cargo);
        bookingService.makeBooking(voyage, cargo1);
        bookingService.makeBooking(voyage, cargo2);
        int result = bookingService.makeBooking(voyage, cargo3);
        System.out.println("booking result: " + result);
        Cargo cargo4 = new Cargo(10);
        result = bookingService.makeBooking(voyage, cargo4);
        System.out.println("booking result: " + result);
    }
}
