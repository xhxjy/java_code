package com.itheima.test5;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread1 extends Thread{
    /*
            有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为 {10,5,20,50,100,200,500,800,2,80,300,700};
            创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”
            随机从抽奖池中获取奖项元素并打印在控制台上,格式如下:
                             每次抽出一个奖项就打印一个(随机)
            	抽奖箱1 又产生了一个 10 元大奖
            	抽奖箱1 又产生了一个 100 元大奖
            	抽奖箱1 又产生了一个 200 元大奖
            	抽奖箱1 又产生了一个 800 元大奖
            	抽奖箱2 又产生了一个 700 元大奖
            	.....
        */

    //抽一个删一个;用集合存储;长度为0时循环结束
    ArrayList<Integer> list;

    public MyThread1(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (MyThread1.class){
                if(list.isEmpty()){
                    System.out.println("奖池已被抽完");
                    break;
                }else{
                    //还可以抽
                    //随机抽,抽一个删一个;
                    Collections.shuffle(list);
                    System.out.println(getName()+"抽到了"+list.getFirst());
                    list.removeFirst();
                }
            }
            //对应的线程睡一会,给其它线程机会
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
