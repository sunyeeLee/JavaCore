package com.sunyee.javacore.base.classloader;

/**
 * 自定义类加载器。将字节码转换为class对象
 * Created by lishunyi on 2019/7/30
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass(String name, byte[] b, int off, int len){
        return super.defineClass(name, b, off, len);
    }
}
