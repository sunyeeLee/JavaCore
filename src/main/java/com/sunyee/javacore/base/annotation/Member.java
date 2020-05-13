package com.sunyee.javacore.base.annotation;

/**
 * 数据库表Member对应实例类bean
 * Created by lishunyi on 2020/4/13
 */
@DBTable(name = "Member")
public class Member {

    @SQLString(name = "ID", value = 50, constraint = @Constraints(primaryKey = true))
    private String id;

    @SQLString(name = "name", value = 30)
    private String name;

    @SQLInteger(name = "age")
    private String age;

    @SQLString(name = "nameDesc", value = 30, constraint = @Constraints(allowNull = true))
    private String desc;
}
