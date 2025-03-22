package a01staticDemo2;

import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();

        Student s1=new Student("xjy",24,"女");
        Student s2=new Student("zqg",18,"男");
        Student s3=new Student("hjy",25,"女");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        int maxAge = StudentUtil.getMaxAge(list);
        System.out.println(maxAge);
    }
}
