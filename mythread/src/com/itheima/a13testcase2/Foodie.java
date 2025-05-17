package com.itheima.a13testcase2;

public class Foodie extends Thread {
    private com.itheima.a13testcase2.Desk desk;

    public Foodie(com.itheima.a13testcase2.Desk desk) {
        this.desk = desk;
    }

    /*
     * 1.死循环
     * 2.同步代码块
     * 3.判断共享数据是否达到结束条件(达到)
     * 4.判断共享数据是否达到结束条件(未达到)
     * */
    @Override
    public void run() {
        while (true) {
            synchronized (com.itheima.a13testcase2.Desk.lock) {
                if (desk.getCount() == 0) {
                    //不可以吃
                    break;
                } else {
                    //还可以吃
                    //判断桌子上是否有面条
                    if (desk.getFlag() == 0) {
                        //有:吃完;
                        // 面条碗数-1;
                        desk.setCount(desk.getCount()-1);
                        System.out.println(getName()+"还可以再吃" + desk.getCount() + "碗");
                        // 并修改桌子上的食物状态;
                        desk.setFlag(1);
                        // 叫醒等待的生产者去做饭
                        com.itheima.a13testcase2.Desk.lock.notifyAll();
                    } else {
                        //没有:等待
                        try {
                            com.itheima.a13testcase2.Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
