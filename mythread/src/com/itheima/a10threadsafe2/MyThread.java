package com.itheima.a10threadsafe2;

public class MyThread implements Runnable{
    //该类只会被创建一次,所以ticket无需用static修饰,
    // 因为该类实现了Runnable接口,创建该类的对象表示线程要执行的任务
    int ticket=0;

    @Override
    public void run() {
        //循环
        while (true){
            //同步代码块
            if (method()) break;
        }
    }

    private synchronized boolean method() {
        if (ticket == 100) {
            //线程结束的条件
            return true;
        } else {
            //线程未结束
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "在卖第" + ticket + "张票");
        }
        return false;
    }
}
