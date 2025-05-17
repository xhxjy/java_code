package com.itheima.a13testcase2;

import com.itheima.a13test.Cook;
import com.itheima.a13test.Foodie;

public class ThreadDemo {
    public static void main(String[] args) {
        com.itheima.a13test.Cook cook = new Cook();
        com.itheima.a13test.Foodie fd = new Foodie();

        cook.setName("厨师");
        fd.setName("吃货");

        cook.start();
        fd.start();
    }
}
