package com.sunyee.javacore.base.concurrent;

/**
 * 读者写者问题
 * 读者—写者问题（Readers-Writers problem）也是一个经典的并发程序设计问题，是经常出现的一种同步问题。计算机系统中的数据（文件、记录）常被多个进程共享，但其中某些进程可能只要求读数据（称为读者Reader）；另一些进程则要求修改数据（称为写者Writer）。就共享数据而言，Reader和Writer是两组并发进程共享一组数据区，要求：
 *
 * （1）允许多个读者同时执行读操作；
 *
 * （2）不允许读者、写者同时操作；
 *
 * （3）不允许多个写者同时操作。
 *
 * Reader和Writer的同步问题分为读者优先、弱写者优先（公平竞争）和强写者优先三种情况，它们的处理方式不同。
 *
 * 首先我们都只考虑公平竞争的情况下，看看Java有哪些方法可以实现读者写者问题
 *
 * 2.1 读写锁
 * ReentrantReadWriteLock会使用两把锁来解决问题，一个读锁，一个写锁
 * 线程进入读锁的前提条件：
 *     没有其他线程的写锁，
 *     没有写请求或者有写请求，但调用线程和持有锁的线程是同一个
 * 线程进入写锁的前提条件：
 *     没有其他线程的读锁
 *     没有其他线程的写锁
 *
 * 到ReentrantReadWriteLock，首先要做的是与ReentrantLock划清界限。它和后者都是单独的实现，彼此之间没有继承或实现的关系。然后就是总结这个锁机制的特性了：
 *
 * 1。重入（在上文ReentrantLock处已经介绍了）方面其内部的WriteLock可以获取ReadLock，但是反过来ReadLock想要获得WriteLock则永远都不要想。
 * 2。WriteLock可以降级为ReadLock，顺序是：先获得WriteLock再获得ReadLock，然后释放WriteLock，这时候线程将保持Readlock的持有。反过来ReadLock想要升级为WriteLock则不可能，为什么？参看(1)，呵呵.
 * 3。ReadLock可以被多个线程持有并且在作用时排斥任何的WriteLock，而WriteLock则是完全的互斥。这一特性最为重要，因为对于高读取频率而相对较低写入的数据结构，使用此类锁同步机制则可以提高并发量。
 * 4。不管是ReadLock还是WriteLock都支持Interrupt，语义与ReentrantLock一致。
 * 5。WriteLock支持Condition并且与ReentrantLock语义一致，而ReadLock则不能使用Condition，否则抛出UnsupportedOperationException异常。
 * Created by lishunyi on 2019/6/25
 */
public class ReadersWritersProblem {
}
