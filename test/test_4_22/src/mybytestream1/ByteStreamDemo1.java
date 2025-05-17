package mybytestream1;


import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * 演示：字节输出流FileOutputStream
        * 实现需求：写出一段文字到本地文件中。（暂时不写中文）
        *
        * 实现步骤：
        *       创建对象
        *       写出数据
        *       释放资源
        * */


        //创建对象,使程序和文件产生联系
        //细节:
        //1.里面的参数可以是文件对象或路径
        // 2.若文件不存在会创建一个新的,但前提是其父级路径要存在
        // 3.若文件存在则会将里面的内容清空
        //FileOutputStream fos=new FileOutputStream(new File("test_4_22\\a.txt"));
        FileOutputStream fos=new FileOutputStream("test_4_22\\a.txt");

         //3个写入数据的方法
        //写入单个数据
        //参数是整数,实际写入的是其对应的ASCII码值
        fos.write(97);
        byte[] arr={99,97,100,111};

        //写入多个数据
        fos.write(arr);

        //数组名,起始索引,获取数据的长度
        fos.write(arr,1,2);

        //每次使用完流后都要释放资源
        //切断程序和文件的联系
        //使程序不占用该文件
        fos.close();





















        /*//1.创建对象
        //写出 输出流 OutputStream
        //本地文件    File
        FileOutputStream fos = new FileOutputStream("myio\\a.txt");
        //2.写出数据
        fos.write(97);
        //3.释放资源
        fos.close();*/



    }
}