package com.itheima.test4case1;

public class Test {
    public static void main(String[] args) {
        /*
            微信中的抢红包也用到了多线程。
            假设：100块，分成了3个包，现在有5个人去抢。
            其中，红包是共享数据。
            5个人是5条线程。
            打印结果如下：
            	XXX抢到了XXX元
            	XXX抢到了XXX元
            	XXX抢到了XXX元
            	XXX没抢到
            	XXX没抢到
        */

        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        MyThread1 t3 = new MyThread1();
        MyThread1 t4 = new MyThread1();
        MyThread1 t5 = new MyThread1();

        t1.setName("a:");
        t2.setName("b:");
        t3.setName("c:");
        t4.setName("d:");
        t5.setName("e:");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();



























        /*//创建线程的对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        //给线程设置名字
        t1.setName("小A");
        t2.setName("小QQ");
        t3.setName("小哈哈");
        t4.setName("小诗诗");
        t5.setName("小丹丹");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();*/




    }
}
