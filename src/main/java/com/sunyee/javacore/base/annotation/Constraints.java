package com.sunyee.javacore.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 约束注解
 * Created by lishunyi on 2020/4/13
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {

    boolean primaryKey() default false; //是否为主键

    boolean allowNull() default false; //是否允许为空

    boolean unique() default false; //是否为唯一值

}
