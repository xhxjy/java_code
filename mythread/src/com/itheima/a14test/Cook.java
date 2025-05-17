package com.itheima.a14test;

import java.util.concurrent.ArrayBlockingQueue;

//cook类
public class Cook extends Thread{
    ArrayBlockingQueue<String> abq;

    public Cook(ArrayBlockingQueue<String> abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true){
            try {
                //放入面条
                abq.put("面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("厨师做了一碗面条");
        }
    }
}
