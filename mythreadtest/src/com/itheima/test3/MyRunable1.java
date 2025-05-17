package com.itheima.test3;

public class MyRunable1 implements Runnable{
    //第二中方式实现多线程,在测试类中只会创建一个对象
    // 表示线程要执行的任务,所以无需加static修饰
    int num=1;

    @Override
    public void run() {
        while (true){
            synchronized (MyRunable1.class){
        //不可以直接用for循环结束,这相当于直接让一个线程把事情全部做完了,没另一个线程什么事了
                /*for(num=1;num<=100;num++){
                    if(num%2!=0){
                        System.out.println(Thread.currentThread().getName()+num);
                    }
                }*/

                if(num>100){
                    break;
                }else{
                    if(num%2!=0){
                        System.out.println(Thread.currentThread().getName()+num);
                    }
                    num++;
                }
            }
        }
    }
}
