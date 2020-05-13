package com.sunyee.javacore.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lishunyi on 2020/4/13
 */
public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {
        String tableSQL = createTableSQL("com.sunyee.javacore.base.annotation.Member");
        System.out.println(tableSQL);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println("year: " + calendar.get(Calendar.YEAR));
    }

    public static String createTableSQL(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        if (dbTable == null){
            System.out.println("No DBTable annotation on class: " + className);
            return null;
        }
        String tableName = dbTable.name();

        List<String> columnDefs = new ArrayList<String>();

        for (Field field: clazz.getDeclaredFields()){
            String columnName = null;
            //获取字段上的注解
            Annotation[] annos = field.getDeclaredAnnotations();
            if (annos.length < 1){
                continue;   //字段上不存在注解
            }

            Annotation fieldAnnotation = annos[0];
            if (fieldAnnotation instanceof SQLInteger){
                SQLInteger sqlInteger = (SQLInteger) fieldAnnotation;
                //获取字段对应列名称，如果没有就是使用字段名称替代
                if (sqlInteger.name().length() < 1){
                    columnName = field.getName();
                } else {
                    columnName = sqlInteger.name();
                }

                //构建语句
                columnDefs.add(columnName + " INT" +
                        getConstraints(sqlInteger.constraint()));
            } else if(fieldAnnotation instanceof SQLString){
                SQLString sqlString = (SQLString) fieldAnnotation;
                //获取字段对应列名称，如果没有就是使用字段名称替代
                if (sqlString.name().length() < 1){
                    columnName = field.getName();
                } else {
                    columnName = sqlString.name();
                }

                columnDefs.add(columnName + " VARCHAR(" +
                        sqlString.value() + ") " +
                        getConstraints(sqlString.constraint()));
            } else {
                //nothing to do
            }

        }

        //数据库建表语句
        StringBuilder createString = new StringBuilder("create table " + tableName + "(");

        for (String columnDef: columnDefs){
            createString.append("\n " + columnDef + ",");
        }

        String sqlString = createString.toString().substring(0, createString.length()-1) + ");";

        return sqlString;

    }

    private static String getConstraints(Constraints constraints){
        StringBuilder con = new StringBuilder();

        if (!constraints.allowNull()){
            con.append(" not null ");
        }
        if (constraints.primaryKey()){
            con.append(" primary key ");
        }
        if (constraints.unique()){
            con.append(" unique ");
        }
        return con.toString();
    }
}
