package com.itheima.a01threadcase1;

public class Thread1 extends Thread{
    @Override
    public void run() {
        //写线程要执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"xjy");
        }
    }
}
