package com.sunyee.javacore.base.concurrent;

import java.util.HashSet;
import java.util.Set;

/**
 * 发布与逸出
 * 逸出(escape)： 当某个不应该被发布的对象被发布时，这种情况就被称之为逸出(escape)现象
 * Created by lishunyi on 2019/7/23
 */
public class PublishAndEscape {

    public static Set<Secrets> knowSecrets;

    public void initialize(){
        knowSecrets = new HashSet<>();
    }
}

class Secrets{}
