package com.itheima.test3;

public class Test {
    public static void main(String[] args) {
        /*
           同时开启两个线程，共同获取1-100之间的所有数字。
           要求：将输出所有的奇数。
        */

        MyRunable1 mr = new MyRunable1();

        //用构造方法创建线程并取名字
        Thread t1 = new Thread(mr,"exit1:");
        Thread t2 = new Thread(mr,"exit2:");

        t1.start();
        t2.start();






























        /*//创建参数对象
        MyRunable mr = new MyRunable();

        //创建线程对象
        Thread t1 = new Thread(mr,"线程A");
        Thread t2 = new Thread(mr,"线程B");

        //启动线程
        t1.start();
        t2.start();*/
    }
}
