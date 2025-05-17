package a01myfunction;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionDemo8 {
    public static void main(String[] args) {
        /*
        *   需求：
        *       创建集合添加学生对象
        *       学生对象属性：name，age
        *   要求：
        *       获取姓名并放到数组当中
        *       使用方法引用完成
        * */
        //1.创建集合
        ArrayList<Student> list = new ArrayList<>();
        //2.添加元素
        list.add(new Student("zhangsan",23));
        list.add(new Student("lisi",24));
        list.add(new Student("wangwu",25));

        //类型转化(student对象--->string)---->Student类中的getName成员方法
        String[] arr = list.stream().map(Student::getName).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));


        //写引用方法的技巧:
        //1.现在是否存在一个方法满足我的需求
        //2.如果存在,这个方法是否满足引用的规则
        //2.1 静态方法
        //2.2 构造方法
        //2.3 成员方法(分4种):类名::成员方法;对象::成员方法;this::成员方法;super::成员方法














        /*//3.获取姓名并放到数组当中

        String[] arr = list.stream().map(Student::getName).toArray(String[]::new);


       *//* String[] arr = list.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        }).toArray(String[]::new);*//*

        System.out.println(Arrays.toString(arr));*/


    }
}
