package com.itheima.myreflect1;

public class MyReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {

        /*
        * 获取class对象的三种方式：
        *   1. Class.forName("全类名");
        *   2. 类名.class
        *   3. 对象.getClass();
        *
        * */


        //第一种:最常用的方式
        //全类名:包名+类名
        Class clazz1 = Class.forName("com.itheima.myreflect1.Student");

        //当作参数来传递
        //如:synchronized (Student.class)
        Class<Student> clazz2 = Student.class;
        System.out.println(clazz1==clazz2);

        //有对象时才用
        Student s=new Student();
        Class<? extends Student> clazz3 = s.getClass();
        System.out.println(clazz2==clazz3);























        /*//1. 第一种方式
        //全类名 ： 包名 + 类名
        //最为常用的
        Class clazz1 = Class.forName("com.itheima.myreflect1.Student");

        //2. 第二种方式
        //一般更多的是当做参数进行传递
        Class clazz2 = Student.class;


       //3.第三种方式
        //当我们已经有了这个类的对象时，才可以使用。
        Student s = new Student();
        Class clazz3 = s.getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);*/


    }
}