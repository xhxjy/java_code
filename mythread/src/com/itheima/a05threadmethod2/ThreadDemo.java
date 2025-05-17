package com.itheima.a05threadmethod2;

public class ThreadDemo {
    public static void main(String[] args){
       /*
            String getName()                    返回此线程的名称
            //若未给线程设置名字,则线程有默认名字(Thread-0,1....)
            void setName(String name)           设置线程的名字（构造方法也可以设置名字）
            //可以通过构造方法来设置名字,但需要在类中写出对应的带参构造函数

            setPriority(int newPriority)        设置线程的优先级
            final int getPriority()             获取线程的优先级
            //默认优先级是5
            //优先级只是概率问题,并不是优先级高的就一定先执行完,线程的执行具有随机性
       */


        //创建线程要执行的参数对象
        MyRunnable mr = new MyRunnable();
        //创建线程对象
        Thread t1 = new Thread(mr,"飞机");
        Thread t2 = new Thread(mr,"坦克");


//        System.out.println(t1.getPriority());
//        System.out.println(t2.getPriority());

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();

























/*

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
*/



    }
}
