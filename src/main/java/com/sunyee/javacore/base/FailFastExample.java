package com.sunyee.javacore.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishunyi on 2020/4/7
 */
public class FailFastExample {

    public static void main(String[] args) {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName); //throw ConcurrentModificationException
            }
        }

        System.out.println(userNames);
    }


    //编译后的代码如下：

//    public static void main(String[] args) {
//        // 使用ImmutableList初始化一个List
//        List<String> userNames = new ArrayList<String>() {{
//            add("Hollis");
//            add("hollis");
//            add("HollisChuang");
//            add("H");
//        }};
//
//        Iterator iterator = userNames.iterator();
//        do
//        {
//            if(!iterator.hasNext())
//                break;
//            String userName = (String)iterator.next();
//            if(userName.equals("Hollis"))
//                userNames.remove(userName);
//        } while(true);
//        System.out.println(userNames);
//    }
}
