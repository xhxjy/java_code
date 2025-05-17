package com.itheima.a02threadcase2;

public class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"jjkk");
        }
    }
}
