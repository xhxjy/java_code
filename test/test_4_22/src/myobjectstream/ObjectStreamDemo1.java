package myobjectstream;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
           需求：
                利用序列化流/对象操作输出流，把一个对象写到本地文件中

           构造方法：
                public ObjectOutputStream(OutputStream out)         把基本流变成高级流
           成员方法：
                public final void writeObject(Object obj)           把对象序列化（写出）到文件中去

        */
        //1.创建对象
        Student stu=new Student("nihao",18,"汉口");
        //2.创建序列化流(高级流,需要关联基础流)
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("test_4_22\\a.txt"));
        //3.写入对象
        oos.writeObject(stu);
        oos.close();
























        /*//1.创建对象
        Student stu = new Student("zhangsan",23);

        //2.创建序列化流的对象/对象操作输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myio\\a.txt"));

        //3.写出数据
        oos.writeObject(stu);

        //4.释放资源
        oos.close();*/





    }
}
