package com.sunyee.javacore.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lishunyi on 2020/4/13
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    String name() default "";   //数据库对应的列名

    int value() default 0;  //字段对应长度

    Constraints constraint() default @Constraints;  //约束条件


}
