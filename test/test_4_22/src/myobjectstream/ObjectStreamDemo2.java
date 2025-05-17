package myobjectstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectStreamDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
           需求：
                利用反序列化流/对象操作输入流，把文件中中的对象读到程序当中
           构造方法：
                public ObjectInputStream(InputStream out)         把基本流变成高级流
           成员方法：
                public Object readObject()                        把序列化到本地文件中的对象，读取到程序中来
        */
        //1.创建反序列化流的对象
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("test_4_22\\a.txt"));
        //2.将序列化的对象读取到程序中
        //细节:一开始默认是object类型,可以通过强转来得到具体的对象
        Student stu =(Student) ois.readObject();
        //3.打印对象
        System.out.println(stu);
        ois.close();




























        /*//1.创建反序列化流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myio\\a.txt"));

        //2.读取数据
        Student o = (Student) ois.readObject();

        //3.打印对象
        System.out.println(o);

        //4.释放资源
        ois.close();*/


    }
}
