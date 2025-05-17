package com.itheima.a14test;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) {
        //创建一个阻塞队列(相当于test13里的桌子,作为一个中间者)
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(1);

        //创建线程对象并把阻塞队列传递过去
        //细节:生产者和消费者必须使用同一队列
        Cook c = new Cook(abq);
        Foodie f = new Foodie(abq);

        c.start();
        f.start();

    }
}
