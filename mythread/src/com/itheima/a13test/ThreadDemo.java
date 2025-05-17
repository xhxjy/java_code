package com.itheima.a13test;

public class ThreadDemo {
    public static void main(String[] args) {
        Cook cook = new Cook();
        Foodie fd = new Foodie();

        cook.setName("厨师");
        fd.setName("吃货");

        cook.start();
        fd.start();
    }
}
