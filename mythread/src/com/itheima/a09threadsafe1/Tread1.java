package com.itheima.a09threadsafe1;

public class Tread1 extends Thread{
    //表示这个类的所有对象共享票数
    static int picket=0;
    //要保证锁的对象是唯一的,这个类的所有对象都共享这个锁对象
//    static final Object obj=new Object();

    @Override
    public void run() {
        while (true) {
            //同步代码块
            synchronized (Tread1.class){//里面直接写本类的class文件即可,它在本文件夹是唯一的
        //每个线程对象,进去只抢一次,假如改为while (picket<100),相当于一个窗口把全部票卖完了,就不符合题目的要求
                if (picket<100) {
                    picket++;
                    System.out.println(getName() + picket);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    break;
                }
            }
        }
    }
}
