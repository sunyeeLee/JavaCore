package com.sunyee.javacore.base.generics;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by lishunyi on 2020/4/9
 */

class Coffee{

    private static long counter = 0;

    private final long id = counter++;

    @Override
    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee{}
class Mocha extends Coffee{}
class Cappuccino extends Coffee{}
class Breve extends Coffee{}
class Ameriacano extends Coffee{}

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++){
            System.out.println(generator.next());
        }

        for (Coffee c: new CoffeeGenerator((5))){
            System.out.println(c);
        }
    }

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Breve.class, Ameriacano.class};

    private int size;

    private static final int DEFAULT_SIZE = 0;
    private static Random random  = new Random(47);
    public CoffeeGenerator(){ size = DEFAULT_SIZE;}

    public CoffeeGenerator(int size){
        this.size = size;
    }


    @Override
    public Coffee next() {
        try {
            return (Coffee)types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    class CoffeeIterator implements Iterator<Coffee>{

        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
}
