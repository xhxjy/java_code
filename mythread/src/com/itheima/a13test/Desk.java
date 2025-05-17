package com.itheima.a13test;

public class Desk extends Thread{
    //面条的碗数
    static int count=10;
    //判断桌子上是否有面条.
    //0:有;  1:没有
    static int flag=1;
    //共享的锁对象(唯一的)
    static final Object lock=new Object();
}
