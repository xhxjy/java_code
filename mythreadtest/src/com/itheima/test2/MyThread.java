package com.itheima.test2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable{
    int gift=100;

    Lock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(gift<10){
                    break;
                }else{
                    Thread.sleep(100);
                    gift--;
                    System.out.println(Thread.currentThread().getName()+"还剩"+gift+"个礼品");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
