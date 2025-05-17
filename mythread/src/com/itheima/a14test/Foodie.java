package com.itheima.a14test;

import java.util.concurrent.ArrayBlockingQueue;


//Foodie类
public class Foodie extends Thread {
    ArrayBlockingQueue<String> abq;

    public Foodie(ArrayBlockingQueue<String> abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true) {
            //拿到食物
            try {
                String food = abq.take();
                System.out.println(food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
