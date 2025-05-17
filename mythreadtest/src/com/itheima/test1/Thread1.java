package com.itheima.test1;

public class Thread1 extends Thread{
    static int ticket=100;

    @Override
    public void run() {
        //循环
        while (true){
            //同步代码块
            synchronized (Thread1.class){
                //判断是否结束
                if(ticket==0){
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket--;
                    System.out.println(getName()+"还剩"+ticket+"张票");
                }
            }
        }
    }
}
