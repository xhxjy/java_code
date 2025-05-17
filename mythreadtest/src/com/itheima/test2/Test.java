package com.itheima.test2;

public class Test {
    public static void main(String[] args) {
        /*
            有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出，
            利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
        */

        /*MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();*/
        MyThread mt = new MyThread();

        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);

        t1.setName("exit1:");
        t2.setName("exit2:");

        t1.start();
        t2.start();




























        /*//创建参数对象
        MyRunable mr = new MyRunable();

        //创建线程对象
        Thread t1 = new Thread(mr,"窗口1");
        Thread t2 = new Thread(mr,"窗口2");

        //启动线程
        t1.start();
        t2.start();*/
    }
}
