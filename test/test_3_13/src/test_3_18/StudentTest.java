package test_3_18;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();//里面是泛型,什么类型都可以加进去
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            Student s=new Student();
            System.out.println("请输入你的姓名:");
            s.setName(sc.next());
            System.out.println("请输入你的年龄:");
            s.setAge(sc.nextInt());
            list.add(s);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getAge());
        }
    }
}
