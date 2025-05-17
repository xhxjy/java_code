package a01myfunction;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionDemo3  {
    public static void main(String[] args) {
        /*
        方法引用（引用成员方法）
        格式
                其他类：其他类对象::方法名
                本类：this::方法名(引用处不能是静态方法)
                父类：super::方法名(引用处不能是静态方法)
        需求：
            集合中有一些名字，按照要求过滤数据
            数据："张无忌","周芷若","赵敏","张强","张三丰"
            要求：只要以张开头，而且名字是3个字的
       */
        /*需求：
            集合中有一些名字，按照要求过滤数据
            数据："张无忌","周芷若","赵敏","张强","张三丰"
            要求：只要以张开头，而且名字是3个字的*/

        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"张无忌","周芷若","赵敏","张强","张三丰");
        //其他类对象::方法名: 过滤的方法写在另一个类的方法中了
        //this::方法名 过滤的方法写在本类的方法中了
        //super::方法名 过滤的方法写在父类的方法中了
        //注意:后面两个的引用处不能是静态方法,因为静态方法中不存在this,super

        //只写一种情况
        list.stream()
                .filter(new StringOperation()::stringJudge)
                .forEach(s-> System.out.println(s));




























        /*//1.创建集合
        ArrayList<String> list = new ArrayList<>();
        //2.添加数据
        Collections.addAll(list,"张无忌","周芷若","赵敏","张强","张三丰");
        //3.过滤数据（只要以张开头，而且名字是3个字的）
        //list.stream().filter(s->s.startsWith("张")).filter(s->s.length() == 3).forEach(s-> System.out.println(s));


      *//*  list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length() == 3;
            }
        }).forEach(s-> System.out.println(s));*//*

      *//*  StringOperation so = new StringOperation();
        list.stream().filter(so::stringJudge)
                .forEach(s-> System.out.println(s));*//*

        //静态方法中是没有this的
        list.stream().filter(new FunctionDemo3()::stringJudge)
                .forEach(s-> System.out.println(s));

    }


    public boolean stringJudge(String s){
        return s.startsWith("张") && s.length() == 3;*/
    }
}
