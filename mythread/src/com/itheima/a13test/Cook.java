package com.itheima.a13test;

public class Cook extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if(Desk.count==0){
                    break;
                }else{
                    //还要做饭
                    //判断桌子上是否有面条
                    //有:等待并唤醒吃货
                    if(Desk.flag==0){
                        try {
//等待和唤醒的方法都要用共享的锁去调用,否则在唤醒的时候不知道要唤醒哪个等待的锁.(使等待和唤醒的锁绑定在一起)
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        //无:做饭,
                        System.out.println(getName()+"做好饭了");
                        //并修改桌子上的食物状态
                        Desk.flag=0;
                        //叫醒等待的消费者去吃,
                        // 为什么知道当前消费者正在等待:因为程序执行到这里时,表明厨师抢到了cpu的执行权,默认吃货在等待
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
