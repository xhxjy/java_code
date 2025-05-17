package com.itheima.a04threadmethod1;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        /*
            String getName()                    返回此线程的名称
            //若未给线程设置名字,则线程有默认名字(Thread-0,1....)
            void setName(String name)           设置线程的名字（构造方法也可以设置名字）
            //可以通过构造方法来设置名字,但需要在类中写出对应的带参构造函数

            static Thread currentThread()       获取当前线程的对象
            //在main中的线程是main线程
            static void sleep(long time)        让线程休眠指定的时间，单位为毫秒
       */
        /*Thread1 t1=new Thread1("nj");
        Thread1 t2=new Thread1("jj");

        t1.start();
        t2.start();*/
        Thread t = Thread.currentThread();
//        System.out.println(t.getName());//main
        System.out.println(111111);
        Thread.sleep(5000);
        System.out.println(222222);
        /*
        * 1.获得线程名字                      String getName()
        * 2.设置线程名字                      void setName(String name)
        * 3.获得当前线程                      static Thread currentThread()
        * 4.线程休眠                          static void sleep(long time)
        * 5.获得和设置优先级
        *   setPriority(int newPriority)        设置线程的优先级
            final int getPriority()             获取线程的优先级
        * 6.守护线程
        *   final void setDaemon(boolean on)    设置为守护线程
        * */

    }
}
