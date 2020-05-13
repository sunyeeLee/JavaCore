package com.sunyee.javacore.ddd.booking;

import java.util.ArrayList;
import java.util.List;

/**
 * 航程
 * Created by lishunyi on 2019/9/17
 */
public class Voyage {

    private int capacity;   //货轮允许承载的最大重量

    private int bookedCargoSize;    //该航程已经订阅的货物重量

    private String desitination;

    private List<Cargo> cargos = new ArrayList<>();

    public Voyage(int capacity, String desitination){
        this.capacity = capacity;
        this.desitination = desitination;
    }

    public void addCargo(Cargo cargo){
        this.cargos.add(cargo);
        this.bookedCargoSize += cargo.getSize();
    }

    public void unsubscribe(Cargo cargo){
        this.cargos.remove(cargo);
    }

    public int getBookedCargoSize() {
        return bookedCargoSize;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDesitination() {
        return desitination;
    }
}
