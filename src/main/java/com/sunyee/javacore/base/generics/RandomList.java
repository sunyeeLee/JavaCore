package com.sunyee.javacore.base.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lishunyi on 2020/4/9
 */
public class RandomList<T> {

    private final List<T> storage = new ArrayList<>();

    private Random random = new Random(47);

    public void add(T item){ this.storage.add(item);}

    /**
     * random return a item in storage
     * @return item which in storage
     */
    public T select(){
        return storage.get(random.nextInt(storage.size()));
    }


    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();

        for(String s: "i am a hero".split(" ")){
            randomList.add(s);
        }

        for (int i = 0; i< 10; i++){
            System.out.println(randomList.select());
        }
    }
}
