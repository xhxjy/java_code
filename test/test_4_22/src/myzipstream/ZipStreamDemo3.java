package myzipstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
         *   压缩流
         *      需求：
         *          把D:\\aaa文件夹压缩成一个压缩包
         * */

        //1.创建file对象表示要压缩的文件夹
        File src = new File("D:\\aaa");
        //创建file对象表示压缩包的目的地,使代码具有通用性
        //若src为:D:xxx\\jjj\\kkk
        //2.创建file对象表示要压缩包的目的地的父级路径
        File destparent = src.getParentFile();
        //3.创建file对象表示要压缩包的目的地
        File dest=new File(destparent,src.getName()+".zip");
        //4.创建压缩输出流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        //5.遍历数据源,获取其中的每一个文件,并将它变为ZipEntry对象,最后将它添加进压缩包中
        toZip(src,zos,src.getName());
        //6.关流
        zos.close();

    }

    //name:压缩包里的内部路径(初始值为数据源的名字,即src.getName():aaa),这个路径会因为递归不断的被刷新
    private static void toZip(File src, ZipOutputStream zos,String name) throws IOException {
        //遍历数据源
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if(file.isFile()){
                    //文件
                    //创建ZipEntry对象并将它添加进压缩包中
//细节:内部的路径理解.若里面的参数为xxx\\jjj\\k.txt,则会先创建xxx,jjj两个文件夹,再创建k.txt这个文件
//所以若file为文件夹时,只需改变(刷新)name即可,无需创建对应的空文件夹
                    ZipEntry entry = new ZipEntry(name+"\\"+file.getName());
                    zos.putNextEntry(entry);
                    //将文件中的数据拷贝到压缩包中
                    FileInputStream fis=new FileInputStream(file);
                    byte[] bytes = new byte[1024 * 1024];
                    int len;
                    while ((len=fis.read(bytes))!=-1){
                        zos.write(bytes,0,len);
                    }
                    fis.close();
                    zos.closeEntry();
                }else{
                    //文件夹(递归)
                    //细节:参数一是当前的文件夹,而不是数据源src
                    toZip(file,zos,name+"\\"+file.getName());
                }
            }
            //程序在递归时会走到这,关流不可放在此处
            //因为递归时需要将整个程序全部执行完才算结束当前递归,所以程序运行中有可能会走到此处
            //zos.close();
        }
    }





























    /*//1.创建File对象表示要压缩的文件夹
        File src = new File("D:\\aaa");
        //2.创建File对象表示压缩包放在哪里（压缩包的父级路径）
        File destParent = src.getParentFile();//D:\\
        //3.创建File对象表示压缩包的路径
        File dest = new File(destParent,src.getName() + ".zip");
        //4.创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        //5.获取src里面的每一个文件，变成ZipEntry对象，放入到压缩包当中
        toZip(src,zos,src.getName());//aaa
        //6.释放资源
        zos.close();*/

    /*
    *   作用：获取src里面的每一个文件，变成ZipEntry对象，放入到压缩包当中
    *   参数一：数据源
    *   参数二：压缩流
    *   参数三：压缩包内部的路径
    * */
    /*public static void toZip(File src,ZipOutputStream zos,String name) throws IOException {
        //1.进入src文件夹
        File[] files = src.listFiles();
        //2.遍历数组
        for (File file : files) {
            if(file.isFile()){
                //3.判断-文件，变成ZipEntry对象，放入到压缩包当中
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName());//aaa\\no1\\a.txt
                zos.putNextEntry(entry);
                //读取文件中的数据，写到压缩包
                FileInputStream fis = new FileInputStream(file);
                int b;
                while((b = fis.read()) != -1){
                    zos.write(b);
                }
                fis.close();
                zos.closeEntry();
            }else{
                //4.判断-文件夹，递归
                toZip(file,zos,name + "\\" + file.getName());
                //     no1            aaa   \\   no1
            }
        }
    }*/
}