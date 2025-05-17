package a08test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
       /* 班级里有N个学生
        要求：
        被点到的学生不会再被点到。
        但是如果班级中所有的学生都点完了，需要重新开启第二轮点名。*/

        //写代码的思路:
        //将一个大要求分为多个个小要求,逐步实现
        //如:将本题分为3个小要求
        //1.被点到的学生不会再被点到(对集合元素进行排重)
        //2.但是如果班级中所有的学生都点完了(循环抽取)
        //3.需要重新开启第二轮点名(需要定义一个临时集合,存储被点名的学生;两个集合间)



        ArrayList<String> nameList = new ArrayList<>();
        Collections.addAll(nameList, "范闲", "范建", "范统", "杜子腾",
                "宋合泛", "侯笼藤", "朱益群", "朱穆朗玛峰");

        //定义一个临时集合存储被点到的学生
        ArrayList<String> list = new ArrayList<>();

        Random r = new Random();

        //外循环:点几次名
        for (int i = 0; i < 5; i++) {
            System.out.println("----------第" + (i + 1) + "轮----------");
            //需要用临时变量来记录名单长度,防止在内循环中,由于元素的删除导致名单长度发生变化,从而影响循环次数
            int count = nameList.size();
            //内循环:将名字全部点一遍并将它们依次存入临时集合中
            //不可将count写为ameList.size(),因为集合的长度会因为元素的删除而改变(减小);否则只会循环名单长度的一半的次数
            for (int j = 0; j < count; j++) {
                //这里的范围(名单长度)不可以用count表示,因为元素的删除会导致长度发生变化(减小)
                //count记录的是名单原长度
                int index = r.nextInt(nameList.size());
                //根据索引将将元素从名单中除去(保证了下次随机元素的唯一性)
                String name = nameList.remove(index);
                //将除去的元素添加进临时集合中
                list.add(name);
                System.out.println(name);
            }

            //一轮结束,将临时集合复制给名单集合,并将临时集合清空
            nameList.addAll(list);
            list.clear();
        }

























        /*//1.定义集合
        ArrayList<String> list1 = new ArrayList<>();
        //2.添加数据
        Collections.addAll(list1, "范闲", "范建", "范统", "杜子腾", "杜琦燕", "宋合泛", "侯笼藤", "朱益群", "朱穆朗玛峰", "袁明媛");
        //创建一个临时的集合，用来存已经被点到学生的名字
        ArrayList<String> list2 = new ArrayList<>();
        //外循环：表示轮数
        for (int i = 1; i <= 10; i++) {
            System.out.println("=========第" + i + "轮点名开始了======================");
            //3.获取集合的长度
            int count = list1.size();
            //4.随机点名
            Random r = new Random();
            //内循环：每一轮中随机循环抽取的过程
            for (int j = 0; j < count; j++) {
                int index = r.nextInt(list1.size());
                String name = list1.remove(index);
                list2.add(name);
                System.out.println(name);
            }
            //此时表示一轮点名结束
            //list1 空了 list2 10个学生的名字
            list1.addAll(list2);
            list2.clear();

        }*/


    }
}
