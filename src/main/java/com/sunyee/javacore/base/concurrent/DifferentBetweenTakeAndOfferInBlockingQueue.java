package com.sunyee.javacore.base.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * BlockingQueue中 take()和offer()之间的区别
 * 1.take 去队列的头部元素, offer返回的是指定index的元素存在与否，true ->exists false ->not exists
 * 2.take()方法当队列为空时会阻塞, offer()方法取不到元素时会返回false，不会阻塞
 * Created by lishunyi on 2019/7/22
 */
public class DifferentBetweenTakeAndOfferInBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.println(queue.size());
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
        System.out.println(queue.take());
        System.out.println(queue.size());

        //output: 0
        //        false
        //        false
        //        false
        //        （阻塞）
    }
}
