package a05myset;

import java.util.HashSet;

public class A03_HashSetDemo2 {
    public static void main(String[] args) {
        /* 需求：创建一个存储学生对象的集合，存储多个学生对象。
            使用程序实现在控制台遍历该集合。
            要求：学生对象的成员变量值相同，我们就认为是同一个对象
        String   Integer
*/
        //1.创建学生对象
        Student s1 = new Student("zhangsan",23);
        Student s2 = new Student("lisi",24);
        Student s3 = new Student("wangwu",25);
        Student s4 = new Student("wangwu",25);

        //2.创建hashset集合
        HashSet<Student> hs=new HashSet<>();

        //3.将学生对象添加进hashset中
        System.out.println(hs.add(s1));
        System.out.println(hs.add(s2));
        System.out.println(hs.add(s3));
        System.out.println(hs.add(s4));//若未重写hashcode和equals方法则为true

        //4.遍历hashset
        for (Student s : hs) {
            System.out.println(s);
        }
























        /*//1.创建三个学生对象
        Student s1 = new Student("zhangsan",23);
        Student s2 = new Student("lisi",24);
        Student s3 = new Student("wangwu",25);
        Student s4 = new Student("zhangsan",23);


        //2.创建集合用来添加学生
        HashSet<Student> hs = new HashSet<>();

        //3.添加元素
        System.out.println(hs.add(s1));
        System.out.println(hs.add(s2));
        System.out.println(hs.add(s3));
        System.out.println(hs.add(s4));

        //4.打印集合
        System.out.println(hs);*/




    }
}
