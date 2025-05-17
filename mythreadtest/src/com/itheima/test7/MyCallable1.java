package com.itheima.test7;

import com.itheima.test6case1.MyThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable1 implements Callable<Integer> {

    ArrayList<Integer> list;

    public MyCallable1(ArrayList<Integer> list) {
        this.list = list;
    }

    //线程一
    static ArrayList<Integer> list1 = new ArrayList<>();
    //线程二
    static ArrayList<Integer> list2 = new ArrayList<>();

    @Override
    public Integer call() throws Exception {
        while (true) {
            synchronized (MyThread.class) {
                if (list.isEmpty()) {
                    //直接跳出循环
                    break;
                } else {
                    //继续抽奖
                    Collections.shuffle(list);
                    int prize = list.remove(0);
                    if("抽奖箱1".equals(Thread.currentThread().getName())){
                        list1.add(prize);
                    }else {
                        list2.add(prize);
                    }
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //在循环外进行判断
        if("抽奖箱1".equals(Thread.currentThread().getName())){
            return getMax(list1);
        }else {
            return getMax(list2);
        }
    }

    public int getMax(ArrayList<Integer> list){
        int max=0;
        for (Integer gift : list) {
            if(gift>max){
                max=gift;
            }
        }
        return max;
    }
}
