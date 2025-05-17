package com.itheima.test6case1;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread1 extends Thread {
    ArrayList<Integer> list;

    //抽奖箱1的奖箱集合
    static ArrayList<Integer> list1=new ArrayList<>();

    //抽奖箱2的奖箱集合
    static ArrayList<Integer> list2=new ArrayList<>();

    public MyThread1(ArrayList<Integer> list) {
        this.list = list;
    }
    //核心:通过获得当前线程的名字来与各线程的名字进行比较,
    // 从而分清当前是哪个线程在运行,便于将元素添加进对应的集合中
    @Override
    public void run() {
        while (true){
            //
            synchronized (MyThread1.class){
                if(list.isEmpty()){
                    //奖箱已被抽空
                    if("抽奖箱1".equals(getName())){
                        //打印抽奖箱1的结果并结束线程
                        System.out.println(getName()+list1.toString()+"最高奖项:"+Collections.max(list1)+"总和:"+getSum(list1));
                        break;
                    }else{
                        //打印抽奖箱2的结果并结束线程
                        System.out.println(getName()+list2.toString()+"最高奖项:"+Collections.max(list2)+"总和:"+getSum(list2));
                        break;
                    }
                }else{
                    //还可以抽奖
                    Collections.shuffle(list);
                    if("抽奖箱1".equals(getName())){
                        //将奖品添加进集合1
                        list1.add(list.getFirst());
                        list.removeFirst();
                    }else{
                        //将奖品添加进集合2
                        list2.add(list.getFirst());
                        list.removeFirst();
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getSum(ArrayList<Integer> list){
        int sum=0;
        for (Integer gift : list) {
            sum+=gift;
        }
        return sum;
    }

}
