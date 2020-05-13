package com.sunyee.javacore.base;

/**
 * Created by lishunyi on 2020/4/8
 */

interface HasBattery{}
interface Waterproof{}
interface Shoots{}

class Toy{
    Toy(){}
    Toy(int i){}
}

class FacnyToy extends Toy implements HasBattery, Waterproof, Shoots{
    FacnyToy(int i){super(i);}
}
public class RTTITest {
    static void printInfo(Class clazz){
        System.out.println("Class name: " + clazz.getName() + " is interface? " +
                "[" + clazz.isInterface() +" ]");
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Canonical name: " + clazz.getCanonicalName());
    }

    public static void main(String[] args) {
        Class clazz = null;
        try{
            clazz = Class.forName("com.sunyee.javacore.base.FacnyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("can not find the class");
            System.exit(1);
        }

        printInfo(clazz);

        for (Class face: clazz.getInterfaces()){
            printInfo(face);
        }

        Class up = clazz.getSuperclass();
        Object obj = null;

        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("can not Instantiation");
            System.exit(1);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("can not Access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
