package a05myset;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A01_SetDemo1 {
    public static void main(String[] args) {
       /*
           利用Set系列的集合，添加字符串，并使用多种方式遍历。
            迭代器
            增强for
            Lambda表达式

        */

        Set<String> s=new HashSet<>();
        boolean r1 = s.add("xjy");
        boolean r2 = s.add("xhn");
        boolean r3 = s.add("zqg");
        boolean r4 = s.add("zqg");

//        System.out.println(r1);
//        System.out.println(r2);
        //1.迭代器
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);//打印出来是无序的,证明set系列集合的特性:元素拿和取的顺序不一定一致
        }

        //2.增强for
        for (String str : s) {
            System.out.println(str);
        }

        //3.Lambda表达式
        s.forEach(string-> System.out.println(string));

//        System.out.println(s);






















/*        //1.创建一个Set集合的对象
        Set<String> s = new HashSet<>();

        //2,添加元素
        //如果当前元素是第一次添加，那么可以添加成功，返回true
        //如果当前元素是第二次添加，那么添加失败，返回false
        s.add("张三");
        s.add("张三");
        s.add("李四");
        s.add("王五");

        //3.打印集合
        //无序
        //System.out.println(s);//[李四, 张三, 王五]

        //迭代器遍历
       *//* Iterator<String> it = s.iterator();
        while (it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
*//*

        //增强for
       *//* for (String str : s) {
            System.out.println(str);
        }*//*

        // Lambda表达式
        s.forEach( str->System.out.println(str));*/


    }
}
