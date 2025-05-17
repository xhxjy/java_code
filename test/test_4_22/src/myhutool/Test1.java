package myhutool;

import cn.hutool.core.io.FileUtil;

import java.io.IOException;
import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) throws IOException {
    /*
        FileUtil类:
                file：根据参数创建一个file对象
                touch：根据参数创建文件

                writeLines：把集合中的数据写出到文件中，覆盖模式。
                appendLines：把集合中的数据写出到文件中，续写模式。
                readLines：指定字符编码，把文件中的数据，读到集合中。
                readUtf8Lines：按照UTF-8的形式，把文件中的数据，读到集合中

                copy：拷贝文件或者文件夹
    */

        /*File file1 = FileUtil.file("D:\\", "xxx", "yyy", "j.txt");
        System.out.println(file1);

        FileUtil.touch(file1);*/

        /*ArrayList<String> list1=new ArrayList<>();
        list1.add("jjj");
        list1.add("jjj");
        list1.add("jjj");
        FileUtil.writeLines(list1,"test_4_22\\a.txt","UTF-8");*/

        System.out.println("jjj");
        ArrayList<String> list=new ArrayList<>();
        list.add("klk");
        list.add("klk");
        list.add("klk");
        FileUtil.appendLines(list,"D:\\java_code\\test\\test_4_22\\a.txt","UTF-8");
        System.out.println("jkl");




















       /* File file1 = FileUtil.file("D:\\", "aaa", "bbb", "a.txt");
        System.out.println(file1);//D:\aaa\bbb\a.txt

        File touch = FileUtil.touch(file1);
        System.out.println(touch);


        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");

        File file2 = FileUtil.writeLines(list, "D:\\a.txt", "UTF-8");
        System.out.println(file2);*/

      /*  ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        File file3 = FileUtil.appendLines(list, "D:\\a.txt", "UTF-8");
        System.out.println(file3);*/


//        List<String> list = FileUtil.readLines("D:\\a.txt", "UTF-8");
//        System.out.println(list);


    }
}
