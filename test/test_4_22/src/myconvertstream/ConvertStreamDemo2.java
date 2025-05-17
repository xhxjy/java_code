package myconvertstream;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
            利用转换流按照指定字符编码写出
        */



        FileWriter fw=new FileWriter("test_4_22\\a.txt", Charset.forName("UTF-8"));

        fw.write("你好,请多多指教");

        fw.close();
































/*
        //1.创建转换流的对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myio\\b.txt"),"GBK");
        //2.写出数据
        osw.write("你好你好");
        //3.释放资源
        osw.close();*/


//        FileWriter fw = new FileWriter("myio\\c.txt", Charset.forName("GBK"));
//        fw.write("你好你好");
//        fw.close();


    }
}
