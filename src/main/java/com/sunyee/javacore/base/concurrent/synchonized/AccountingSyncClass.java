package com.sunyee.javacore.base.concurrent.synchonized;

/**
 * synchronized作用于类方法
 * Created by lishunyi on 2020/4/14
 */
public class AccountingSyncClass implements Runnable {

    static int i = 0;

    /**
     * synchronized作用于类方法时是给当前class对象加锁
     */
    public static synchronized void increase(){
        i++;
    }

    /**
     * 实例方法，访问时锁不一样不会发生互斥
     */
    public synchronized void increaseForObject(){
        i++;
    }
    @Override
    public void run() {
        for (int j=0; j<100000; j++){
            increase();
        }
    }

    /**
     * 由于synchronized关键字修饰的是静态increase方法，与修饰实例方法不同的是，其锁对象是当前类的class对象。
     * 注意代码中的increase4Obj方法是实例方法，其对象锁是当前实例对象，如果别的线程调用该方法，将不会产生互斥现象，
     * 毕竟锁对象不同，但我们应该意识到这种情况下可能会发现线程安全问题(操作了共享静态变量i)
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new AccountingSyncClass());
        Thread thread2 = new Thread(new AccountingSyncClass());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(AccountingSyncClass.i);
    }

}
