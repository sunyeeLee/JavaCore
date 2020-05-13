package com.sunyee.javacore.base;

/**
 * Created by lishunyi on 2019/5/8
 */

//由于接口不允许定义静态代码块，因此此类用来辅助输出顶层接口的初始化情况
class Output {

    public static String printWhenInit(String s){
        System.out.println(s);
        return s.substring(s.indexOf(" "));
    }
}

interface TopParent {
    String SUPER_FIELD = Output.printWhenInit(" initializing TopParent.SUPER_FIELD ");
}

interface ParentInitial extends TopParent{
    String FIELD = "initializing ParentInitial.SECOND_LEVEL_PARENT_FIELD ";
    String SECOND_LEVEL_PARENT_FIELD = Output.printWhenInit("initializing ParentInitial.SECOND_LEVEL_PARENT_FIELD ");
}

interface SubI extends ParentInitial{
    String SUB_FIELD = Output.printWhenInit(" initializing SubI.SUB_FIELD ");
}

public class InterfaceInitial{
    public static void main(String[] args) {
        System.out.println(SubI.FIELD);
    }
}

