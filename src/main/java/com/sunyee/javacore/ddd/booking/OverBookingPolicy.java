package com.sunyee.javacore.ddd.booking;

/**
 * 货物超订策略。
 * 超订规则，货物重量不能超过航程所允许的110%
 * Created by lishunyi on 2019/9/17
 */
public class OverBookingPolicy {

    public boolean isAllowed(Voyage voyage, Cargo cargo){
        if (voyage.getBookedCargoSize() + cargo.getSize() > voyage.getCapacity() * 1.1){
            return false;
        }
        return true;
    }
}
