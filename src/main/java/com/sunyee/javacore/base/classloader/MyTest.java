package com.sunyee.javacore.base.classloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试加载Programmer类
 * Created by lishunyi on 2019/7/30
 */
public class MyTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        File file = new File(".");
        System.out.println(file.getCanonicalPath());
        InputStream is = new FileInputStream(file.getCanonicalPath() + "/target/classes/com/sunyee/javacore/base/classloader/Programmer.class");
        byte[] result = new byte[1024];
        int count = is.read(result);
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass(null, result, 0 , count);
        System.out.println("class name: " + clazz.getCanonicalName());
        Object o = clazz.newInstance();
        //调用code方法
        clazz.getMethod("code", null).invoke(o, null);

    }
}
