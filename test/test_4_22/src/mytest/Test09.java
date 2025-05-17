package mytest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test09 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //反序列化多个自定义对象
        //1.创建反序列化流对象
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("test_4_22\\a.txt"));
        //2.读取内容并强转为对应的集合类型
        ArrayList<Student> list=(ArrayList<Student>) ois.readObject();
        //3.遍历集合
        for (Student stu : list) {
            System.out.println(stu);
        }
        //4.关流
        ois.close();
    }
}
