package com.itheima.a01threadcase1;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        * 多线程的第一种启动方式：
        *   1. 自己定义一个类继承Thread
        *   2. 重写run方法
        *   3. 创建子类的对象，并启动线程
        * */
        //定义一个类继承thread类
        //重写run方法
        //创建子类的对象,并调用start方法,开启线程
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();

        t1.setName("线程1");
        t1.setName("线程2");
        //细节:不是调用run方法,而是调用start方法(启动线程)
        t1.start();
        t2.start();





























        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();



    }
}
