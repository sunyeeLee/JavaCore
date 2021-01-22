package com.sunyee.javacore.base.collection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMap capacity 会自动选择大于initialCapacity的第一个2的幂次方数字作为容量
 * Created by lishunyi on 2021/1/22
 */
public class HashMapTest {

    public static void testCapacity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Map<String, String> map = new HashMap<String, String>(1);

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Map<String, String> map1 = new HashMap<String, String>(7);

        Class<?> mapType1 = map.getClass();
        Method capacity1 = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map1));


        Map<String, String> map2 = new HashMap<String, String>(9);

        Class<?> mapType2 = map2.getClass();
        Method capacity2 = mapType2.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map2));


        Map<String, String> map3 = new HashMap<String, String>(2);

        Class<?> mapType3 = map2.getClass();
        Method capacity3 = mapType3.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map3));
    }

    public static void testThreshold() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Map<String, String> map = new HashMap<>();
        map.put("hollis1", "hollischuang");
        map.put("hollis2", "hollischuang");
        map.put("hollis3", "hollischuang");
        map.put("hollis4", "hollischuang");
        map.put("hollis5", "hollischuang");
        map.put("hollis6", "hollischuang");
        map.put("hollis7", "hollischuang");
        map.put("hollis8", "hollischuang");
        map.put("hollis9", "hollischuang");
        map.put("hollis10", "hollischuang");
        map.put("hollis11", "hollischuang");
        map.put("hollis12", "hollischuang");
        Class<?> mapType = map.getClass();

        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));

        Field threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold : " + threshold.get(map));

        Field loadFactor = mapType.getDeclaredField("loadFactor");
        loadFactor.setAccessible(true);
        System.out.println("loadFactor : " + loadFactor.get(map));

        map.put("hollis13", "hollischuang");
        Method capacity1 = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size1 = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));

        Field threshold1 = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold : " + threshold.get(map));

        Field loadFactor1 = mapType.getDeclaredField("loadFactor");
        loadFactor.setAccessible(true);
        System.out.println("loadFactor : " + loadFactor.get(map));
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        testCapacity();
        System.out.println("******************************");
        testThreshold();
    }
}
