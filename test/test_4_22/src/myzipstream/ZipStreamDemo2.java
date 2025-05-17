package myzipstream;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
         *   压缩流
         *      需求：
         *          把D:\\a.txt打包成一个压缩包
         * */

        //1.创建file对象表示要压缩的文件
        File src = new File("D:\\csb.txt");
        //2.创建file对象表示压缩包的位置
        File dest = new File("D:\\");
        //3.进行压缩
        toZip(src,dest);
    }

    //压缩
    //参数:数据源,目的地
    public static void toZip(File src,File dest) throws IOException {
        //1.创建压缩输出流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream
                (new File(dest, src.getName().split("\\.")[0] + ".zip")));
        //2.创建ZipEntry对象,表示压缩包里的每一个条目
        //构造方法的参数:压缩包中的目录.
        ZipEntry entry=new ZipEntry(src.getName());
        //3.将创建好的ZipEntry对象添加进压缩包中
        zos.putNextEntry(entry);
        //4.将数据源拷贝进压缩包中
        FileInputStream fis=new FileInputStream(src);

        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len=fis.read(bytes))!=-1){
            zos.write(bytes,0,len);
        }
        //5.关闭3个流
        fis.close();
        zos.closeEntry();
        zos.close();
    }






























    /*//1.创建File对象表示要压缩的文件
        File src = new File("D:\\a.txt");
        //2.创建File对象表示压缩包的位置
        File dest = new File("D:\\");
        //3.调用方法用来压缩
        toZip(src,dest);*/

    /*
    *   作用：压缩
    *   参数一：表示要压缩的文件
    *   参数二：表示压缩包的位置
    * */
    /*public static void toZip(File src,File dest) throws IOException {
        //1.创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest,"a.zip")));
        //2.创建ZipEntry对象，表示压缩包里面的每一个文件和文件夹
        //参数：压缩包里面的路径
        ZipEntry entry = new ZipEntry("aaa\\bbb\\a.txt");
        //3.把ZipEntry对象放到压缩包当中
        zos.putNextEntry(entry);
        //4.把src文件中的数据写到压缩包当中
        FileInputStream fis = new FileInputStream(src);
        int b;
        while((b = fis.read()) != -1){
            zos.write(b);
        }
        zos.closeEntry();
        zos.close();
    }*/
}
