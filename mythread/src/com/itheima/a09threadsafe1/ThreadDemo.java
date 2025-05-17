package com.itheima.a09threadsafe1;

public class ThreadDemo {
    public static void main(String[] args) {
       /*
           需求：
                某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
       */
        //创建3个线程,进行抢票操作
        Tread1 t1=new Tread1();
        Tread1 t2=new Tread1();
        Tread1 t3=new Tread1();

        t1.setName("aaa");
        t2.setName("bbb");
        t3.setName("ccc");

        //线程结束的条件:本质上就是要执行的任务(方法)结束后,线程就结束了,
        // 只不过有多个线程争夺cpu的使用权罢了
        t1.start();
        t2.start();
        t3.start();


























        /*//创建线程对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        //起名字
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        //开启线程
        t1.start();
        t2.start();
        t3.start();*/



    }
}