package com.itheima.test7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    //奖池
    ArrayList<Integer> list;

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        //每个线程都有自己独立的栈空间(线程栈),每个线程的内存都会加载出自己的boxList集合
        ArrayList<Integer> boxList = new ArrayList<>();//1 //2
        while (true) {
            synchronized (MyCallable.class) {
                if (list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + boxList);
                    break;
                } else {
                    //继续抽奖
                    //抽一个,加一个,删一个(同一个)
                    Collections.shuffle(list);
                    int prize = list.removeFirst();
                    boxList.add(prize);
                }
            }
            //使线程执行分布更加均匀(对应的线程睡一会,给其它线程机会)
            Thread.sleep(10);
        }
        //把集合中的最大值返回
        if(boxList.isEmpty()){//当线程数大于奖品数时,线程首次抢到锁奖池已空时会发生此种情况
            return null;
        }else{
            return Collections.max(boxList);
        }
    }
}