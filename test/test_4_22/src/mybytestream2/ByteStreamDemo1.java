package mybytestream2;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
         * 演示：字节输入流FileInputStream
         * 实现需求：读取文件中的数据。（暂时不写中文）
         *
         * 实现步骤：
         *       创建对象
         *       读取数据
         *       释放资源
         * */


        //若文件不存在,直接报错;因为就算创建一个新的文件夹,
        // 那也是空的,没有数据,没有任何意义
        //与FileOutputStream相比
        //FileInputStream是要读取数据(当前没有数据)
        //而FileOutputStream是要写出数据(当前有数据)
        FileInputStream fis=new FileInputStream(new File("test_4_22\\a.txt"));

        //读取数据
        //细节:
        // 1.读取出来的是对应的ASCII码值
        // 2.读取不到数据时(读取到末尾时)返回-1
        //若在文件中写了-1,但是读取时是将它分为负号和1两部分来读取的
        /*System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());*/

        //调用一次read方法其内部的指针就会指向下一个元素
        // 所以需要调用第三方变量来代指这次被读取到的元素
        //总结:整个循环中只能调用一次read方法

        //错误示例
        //多次调用造成元素丢失
        /*while (fis.read()!=-1){
            int result = fis.read();
            System.out.println((char)result);
        }*/
        //正确示例
        int b;
        while ((b=fis.read())!=-1){
            System.out.println((char)b);
        }

        fis.close();



























/*
        //1.创建对象
        FileInputStream fis = new FileInputStream("myio\\a.txt");
        //2.读取数据
        int b1 = fis.read();
        System.out.println((char)b1);
        int b2 = fis.read();
        System.out.println((char)b2);
        int b3 = fis.read();
        System.out.println((char)b3);
        int b4 = fis.read();
        System.out.println((char)b4);
        int b5 = fis.read();
        System.out.println((char)b5);
        int b6 = fis.read();
        System.out.println(b6);//-1
        //3.释放资源
        fis.close();*/

    }
}
