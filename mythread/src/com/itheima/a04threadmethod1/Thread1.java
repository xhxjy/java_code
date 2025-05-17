package com.itheima.a04threadmethod1;

public class Thread1 extends Thread{
    public Thread1() {
    }

    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"="+i);
        }
    }
}
