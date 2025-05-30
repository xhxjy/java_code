package a01myfile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo3 {
    public static void main(String[] args) {
     /*
        public long length()                返回文件的大小（字节数量）
        public String getAbsolutePath()     返回文件的绝对路径
        public String getPath()             返回定义文件时使用的路径
        public String getName()             返回文件的名称，带后缀
        public long lastModified()          返回文件的最后修改时间（时间毫秒值）
     */


        //返回文件的大小（字节数量）
        File f1 = new File("D:\\aaa\\a.txt");
        System.out.println(f1.length());
        //细节:不可以直接返回文件夹的大小(大小为0),
        // 若需要获得其大小,需要将文件夹里的文件大小累加得到
        File f2 = new File("D:\\aaa\\bbb");
        System.out.println(f2.length());

        //返回文件的绝对路径
        System.out.println(f1.getAbsolutePath());
        //传入相对路径,获得其绝对路径
        //相对路径:从项目目录开始的路径,较为便捷,开发时常用
        //绝对路径:从电脑盘符(D盘之类的)开始的路径
        File f3 = new File("test_4_22\\aaa\\a.txt");
        System.out.println(f3.getAbsolutePath());

        //返回定义文件时使用的路径
        System.out.println(f1.getPath());
        System.out.println(f3.getPath());

        //返回文件的名称，带后缀
        //细节:若为文件夹,则只会返回其名字
        System.out.println(f1.getName());
        System.out.println(f2.getName());

        //返回文件的最后修改时间（时间毫秒值）
        long time = f1.lastModified();
        System.out.println(time);

        //根据时间毫秒值获得日期对象
        Date d1 = new Date(time);
        //利用带参的构造方法来创建出指定日期格式的SimpleDateFormat对象
        SimpleDateFormat patern = new SimpleDateFormat("yyyy年MM月dd日");
        //调用对应的成员方法
        System.out.println(patern.format(d1));







































        /*//1.length  返回文件的大小（字节数量）
        //细节1：这个方法只能获取文件的大小，单位是字节
        //如果单位我们要是M，G，可以不断的除以1024
        //细节2：这个方法无法获取文件夹的大小
        //如果我们要获取一个文件夹的大小，需要把这个文件夹里面所有的文件大小都累加在一起。

        File f1 = new File("D:\\aaa\\a.txt");
        long len = f1.length();
        System.out.println(len);//12

        File f2 = new File("D:\\aaa\\bbb");
        long len2 = f2.length();
        System.out.println(len2);//0

        System.out.println("====================================");

        //2.getAbsolutePath 返回文件的绝对路径
        File f3 = new File("D:\\aaa\\a.txt");
        String path1 = f3.getAbsolutePath();
        System.out.println(path1);

        File f4 = new File("myFile\\a.txt");
        String path2 = f4.getAbsolutePath();
        System.out.println(path2);


        System.out.println("====================================");

        //3.getPath 返回定义文件时使用的路径
        File f5 = new File("D:\\aaa\\a.txt");
        String path3 = f5.getPath();
        System.out.println(path3);//D:\aaa\a.txt

        File f6 = new File("myFile\\a.txt");
        String path4 = f6.getPath();
        System.out.println(path4);//myFile\a.txt

        System.out.println("====================================");


        //4.getName 获取名字
        //细节1：
        //a.txt:
        //      a 文件名
        //      txt 后缀名、扩展名
        //细节2：
        //文件夹：返回的就是文件夹的名字
        File f7 = new File("D:\\aaa\\a.txt");
        String name1 = f7.getName();
        System.out.println(name1);


        File f8 = new File("D:\\aaa\\bbb");
        String name2 = f8.getName();
        System.out.println(name2);//bbb

        System.out.println("====================================");

        //5.lastModified  返回文件的最后修改时间（时间毫秒值）
        File f9 = new File("D:\\aaa\\a.txt");
        long time = f9.lastModified();
        System.out.println(time);//1667380952425*/

        //如何把时间的毫秒值变成字符串表示的时间呢？
        //课堂练习：
        //yyyy年MM月dd日 HH：mm：ss



    }
}
