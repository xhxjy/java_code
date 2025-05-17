package com.itheima.a02threadcase2;

public class ThreadTest {
    public static void main(String[] args) {
        /*
        * 1.创建一个类实现Runnable接口
        * 2.创建一个自定义类的对象,表示线程要执行的任务
        * 3.创建两个Thread类的对象,表示2个线程,构造方法传递线程要执行的任务(自定义对象)
        * 4.开启线程*/
        //1.创建一个类实现Runnable接口

        //2.创建一个自定义类的对象,表示线程要执行的任务
        MyThread run =new MyThread();
        //3.创建两个Thread类的对象,表示2个线程,构造方法传递线程要执行的任务(自定义对象)
        //多个线程执行同一任务
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
