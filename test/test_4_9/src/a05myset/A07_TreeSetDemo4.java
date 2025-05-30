package a05myset;

import java.util.Iterator;
import java.util.TreeSet;

public class A07_TreeSetDemo4 {
    public static void main(String[] args) {
      /*  需求：创建5个学生对象
        属性：(姓名,年龄，语文成绩,数学成绩,英语成绩),
        按照总分从高到低输出到控制台
        如果总分一样，按照语文成绩排
        如果语文一样，按照数学成绩排
        如果数学成绩一样，按照英语成绩排
        如果英文成绩一样，按照年龄排
        如果年龄一样，按照姓名的字母顺序排
        如果都一样，认为是同一个学生，不存。

        第一种：默认排序/自然排序
        第二种：比较器排序

        默认情况下，用第一种排序方式，如果第一种不能满足当前的需求，采取第二种方式。


        课堂练习：
            要求：在遍历集合的时候，我想看到总分。

      */


        //1.创建学生对象
        Student2 s1 = new Student2("zhangsan",23,90,99,50);
        Student2 s2 = new Student2("lisi",24,90,98,50);
        Student2 s3 = new Student2("wangwu",25,95,100,30);
        Student2 s4 = new Student2("zhaoliu",26,60,99,70);
        Student2 s5 = new Student2("qianqi",26,70,80,70);

        //2.创建treeset集合
        TreeSet<Student2> ts = new TreeSet<>();

        //3.添加学生到集合中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);

        //
//        System.out.println(ts);

        //lambda表达式
        /*ts.forEach(s-> {
            int result = s.getChinese() + s.getMath() + s.getEnglish();
            System.out.println("总分:"+result);
        });*/
        //
        /*for (Student2 s : ts) {

        }*/
        //迭代器
        Iterator<Student2> it = ts.iterator();
        while (it.hasNext()){
            Student2 s = it.next();
            int result = s.getChinese() + s.getMath() + s.getEnglish();
            System.out.println(result);
        }












        /*//2.创建集合
        TreeSet<Student2> ts = new TreeSet<>();

        //3.添加元素
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);

        //4.打印集合
        //System.out.println(ts);
        for (Student2 t : ts) {
            System.out.println(t);
        }*/

    }
}
