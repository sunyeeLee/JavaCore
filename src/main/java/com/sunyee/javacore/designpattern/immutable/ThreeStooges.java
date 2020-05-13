package com.sunyee.javacore.designpattern.immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * 正确地构造对象
 * Created by lishunyi on 2019/7/23
 */
public final class ThreeStooges {

    private final Set<String> stooges  = new HashSet<>();

    public ThreeStooges(){
        stooges.add("li");
        stooges.add("liu");
        stooges.add("yuchi");
    }

    public boolean constains(String name){
        return stooges.contains(name);
    }
}
