package a01myfile;

import java.io.File;
import java.io.IOException;

public class FileDemo4 {
    public static void main(String[] args) throws IOException {
      /*
        public boolean createNewFile()      创建一个新的空的文件
        public boolean mkdirs()             创建多级文件夹
        public boolean delete()             删除文件、空文件夹
      */

        //createNewFile
        //细节:
        // 1.文件不存在,返回true,表示创建成功
        // 2.父级路径不存在会产生异常IOException
        // 3.创建的一定是文件,若路径中没有后缀名,则直接创建没有后缀的文件
        File f1 = new File("D:\\aaa\\hhh");
        boolean flag1 = f1.createNewFile();
        System.out.println(flag1);

        //mkdirs
        //创建单级和多级文件夹
        File f2 = new File("D:\\zzz");
        System.out.println(f2.mkdirs());
        File f3 = new File("D:\\xxx\\jjj\\yyy");
        System.out.println(f3.mkdirs());

        //delete:删除文件、空文件夹
        //细节:不会走回收站,直接删除
        File f4 = new File("D:\\aaa\\xxx");//里面还有内容
        System.out.println(f1.delete());
        System.out.println(f2.delete());
        System.out.println(f4.delete());//false
















        //1.createNewFile 创建一个新的空的文件
        //细节1：如果当前路径表示的文件是不存在的，则创建成功，方法返回true
        //      如果当前路径表示的文件是存在的，则创建失败，方法返回false
        //细节2：如果父级路径是不存在的，那么方法会有异常IOException
        //细节3：createNewFile方法创建的一定是文件，如果路径中不包含后缀名，则创建一个没有后缀的文件
        /*File f1 = new File("D:\\aaa\\ddd");
        boolean b = f1.createNewFile();
        System.out.println(b);//true*/


        //2.mkdir   make Directory，文件夹（目录）
        //细节1：windows当中路径是唯一的，如果当前路径已经存在，则创建失败，返回false
        //细节2：mkdir方法只能创建单级文件夹，无法创建多级文件夹。
      /*  File f2 = new File("D:\\aaa\\aaa\\bbb\\ccc");
        boolean b = f2.mkdir();
        System.out.println(b);*/

        //3.mkdirs   创建多级文件夹
        //细节：既可以创建单级的，又可以创建多级的文件夹
//        File f3 = new File("D:\\aaa\\ggg");
//        boolean b = f3.mkdirs();
//        System.out.println(b);//true

    }
}
