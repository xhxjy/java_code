package com.itheima.a09threadsafe1;

public class MyThread extends Thread {
    int ticket = 0;//0 ~ 99
    @Override
    public void run() {
        while (true) {
            if (ticket < 100) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket++;
                System.out.println(getName() + "正在卖第" + ticket + "张票！！！");
            } else {
                break;
            }
        }
    }
}
