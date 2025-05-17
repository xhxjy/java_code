package com.itheima.a13test;

public class Foodie extends Thread {
    /*
     * 1.死循环
     * 2.同步代码块
     * 3.判断共享数据是否达到结束条件(达到)
     * 4.判断共享数据是否达到结束条件(未达到)
     * */
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    //不可以吃
                    break;
                } else {
                    //还可以吃
                    //判断桌子上是否有面条
                    if (Desk.flag == 0) {
                        //有:吃完;
                        // 面条碗数-1;
                        Desk.count--;
                        System.out.println(getName()+"还可以再吃" + Desk.count + "碗");
                        // 并修改桌子上的食物状态;
                        Desk.flag = 1;
                        // 叫醒等待的生产者去做饭
                        Desk.lock.notifyAll();
                    } else {
                        //没有:等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
