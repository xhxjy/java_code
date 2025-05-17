package com.itheima.a11threadsafe3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tread1 extends Thread {
    //表示这个类的所有对象共享票数
    static int picket = 0;

    //要用static修饰,使类的所有对象都共享一把锁
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //关锁语句写在try语句的前面
            lock.lock();
            //将同步代码块全部放入try的代码块中,finally代码块写开锁语句
            try {
                //同步代码块
//            synchronized (Tread1.class){
                if (picket == 100) {
                    break;
                } else {
                    picket++;
                    System.out.println(getName() + "在卖第" + picket + "张票！！！");
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            //}
        }
    }
}
