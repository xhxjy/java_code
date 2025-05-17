package com.itheima.a03threadcase3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个类实现Callable1接口,重写call方法
        //创建Callable1的对象(表示线程要执行的任务)
        Callable1 run=new Callable1();
        //传入Callable1的对象并创建FutureTask对象,管理线程运行的结果
        FutureTask<Integer> ft = new FutureTask<>(run);
        //传入FutureTask的对象并创建Thread类的对象,然后开启线程
        Thread t=new Thread(ft);
        t.start();
        //能够获得线程运行的结果
        System.out.println(ft.get());
    }
}
