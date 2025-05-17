package com.itheima.myreflect5;

import java.io.*;
import java.lang.reflect.Field;

public class MyReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, IOException {
    /*
        对于任意一个对象，都可以把对象所有的字段名和值，保存到文件中去
    */
       Student s = new Student("小A",23,'女',167.5,"睡觉");
       Teacher t = new Teacher("播妞",10000);
       saveObject(t);
    }

    private static void saveObject(Object o) throws IllegalAccessException, IOException {
        //获取对象里的成员变量
        //获取对应类的字节码文件,已经有类的对象,用第三种方法
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        BufferedWriter bw =new BufferedWriter(new FileWriter("D:\\java_code\\myreflect\\a.txt",true));
        //遍历成员变量
        for (Field field : fields) {
            //获取成员变量对象里指定对象的成员变量的值
            //细节:需要临时解开权限校验
            field.setAccessible(true);
            //获取成员变量的在对象中的值
            Object object = field.get(o);
            //获取成员变量的名字
            String name = field.getName();
            //将值和名字写入文件
            bw.write(name+"="+object);
            bw.newLine();
        }
        bw.close();
    }




























/*
    //把对象里面所有的成员变量名和值保存到本地文件中
    public static void saveObject(Object obj) throws IllegalAccessException, IOException {
        //1.获取字节码文件的对象
        Class clazz = obj.getClass();
        //2. 创建IO流
        BufferedWriter bw = new BufferedWriter(new FileWriter("myreflect\\a.txt"));
        //3. 获取所有的成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            //获取成员变量的名字
            String name = field.getName();
            //获取成员变量的值
            Object value = field.get(obj);
            //写出数据
            bw.write(name + "=" + value);
            bw.newLine();
        }

        bw.close();*/

//    }
}