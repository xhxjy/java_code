package mycharstream1;


import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
            第一步：创建对象
            public FileReader(File file)        创建字符输入流关联本地文件
            public FileReader(String pathname)  创建字符输入流关联本地文件

            第二步：读取数据
            public int read()                   读取数据，读到末尾返回-1
            public int read(char[] buffer)      读取多个数据，读到末尾返回-1

            第三步：释放资源
            public void close()                 释放资源/关流
        */

        FileReader fr=new FileReader("test_4_22\\a.txt");

        //一次读取多个数据
        //创建一个char类型的数组
        char[] chars = new char[4];
        //read(chars):解码,强转合并了,将文本对应的字符放在数组中
        //相当于:read()+强转
        int b;
        while ((b=fr.read(chars))!=-1){
            //根据读取的元素个数截取数组中有效的数据,并将它们转为字符串,最后打印出来
            System.out.print(new String(chars, 0, b));
        }

        fr.close();




























        /*//1.创建对象
        FileReader fr = new FileReader("myio\\a.txt");
        //2.读取数据
        char[] chars = new char[2];
        int len;
        //read(chars)：读取数据，解码，强转三步合并了，把强转之后的字符放到数组当中
        //空参的read + 强转类型转换
        while((len = fr.read(chars)) != -1){
            //把数组中的数据变成字符串再进行打印
            System.out.print(new String(chars,0,len));
        }
        //3.释放资源
        fr.close();*/

    }
}