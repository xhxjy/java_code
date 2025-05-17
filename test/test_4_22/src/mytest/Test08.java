package mytest;

import java.io.IOException;

public class Test08 {
    public static void main(String[] args) throws IOException {
        /*//序列化多个自定义对象
        //1.创建对象
        Student s1=new Student("iu",22);
        Student s2=new Student("kk",19);
        Student s3=new Student("jj",25);
        //2.创建集合并将对象添加进来
        ArrayList<Student> list=new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        //3.写入集合
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("test_4_22\\a.txt"));
        oos.writeObject(list);
        //4.关流
        oos.close();*/
        Student s1 = new Student("kkk", 18);
        Student s2 = new Student("kkk", 18);
        Student s3 = new Student("kkk", 18);
        System.out.println(s1);
    }
}
