package mytest;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws IOException {
        //需求:拷贝一个文件夹，考虑子文件夹

        //1.创建数据源和目的地的file对象
        File from = new File("D:\\aaa");
        File to = new File("D:\\jjj");
        //2.开始拷贝
        check(from,to);

    }

    //拷贝一个文件夹
    public static void check(File from,File to) throws IOException {
        //第一次:若目的地的文件夹不存在则会创建一个空文件夹;若存在也不会报错
        //第二次及以后:根据刷新的路径来创建对应的空文件夹
        to.mkdirs();
        //1.进入数据源
        File[] files = from.listFiles();
        if(files!=null){
            //2.遍历数组
            for (File file : files) {
                //file对象不是文件就是文件夹
                if(file.isFile()){
                    //3.文件,进行对应操作
                    FileInputStream fis = new FileInputStream(file);
                    //细节:刷新路径,即目的地的文件路径需要加上新的文件对应的路径(从文件到文件,而不是拷贝在文件夹上)
                    FileOutputStream fos = new FileOutputStream(new File(to, file.getName()));
                    //拷贝数据
                    byte[] bytes = new byte[1024 * 1024];
                    int len;
                    while ((len=fis.read(bytes))!=-1){
                        fos.write(bytes,0,len);
                    }
                    fos.close();
                    fis.close();
                } else {
                    //4.文件夹,递归
                    //拷贝一个文件夹(重复方法,即递归)
                    //细节:刷新路径
                    check(file,new File(to,file.getName()));
                }
            }
        }
    }































    /*//遍历数据源,再拷贝文件
    public static void check(File from,File to) throws IOException {
        FileInputStream fis=new FileInputStream(from);
        //先遍历数据源
        File[] files = from.listFiles();
        if(files!=null){
            for (File file : files) {
                if(file.isFile()){
                    //是文件,进行拷贝
                    //创建空文件:(file,)
                    String child = file.getName();
                    File newTo = new File(to, child);
                    //创建FileOutputStream对象
                    FileOutputStream fos=new FileOutputStream(newTo);
                    //拷贝数据
                    byte[] bytes = new byte[1024 * 1024];
                    int len;
                    while ((len=fis.read(bytes))!=-1){
                        fos.write(bytes,0,len);
                    }
                }else if(file.isDirectory()){
                    //是文件夹
                    //先创建空文件夹
                    //如何创建空文件夹
                    //获取数据源的文件夹名,并将它与目标源的路径拼接起来
                    String child = file.getName();
                    File newTo = new File(to, child);
                    //创建FileOutputStream对象
                    FileOutputStream fos=new FileOutputStream(newTo);
                    //再遍历里面的文件
                    check(file,newTo);
                }
            }
        }
    }*/
































    /*//1.创建对象表示数据源
        File src = new File("D:\\aaa\\src");
        //2.创建对象表示目的地
        File dest = new File("D:\\aaa\\dest");

        //3.调用方法开始拷贝
        copydir(src,dest);*/
    /*
    * 作用：拷贝文件夹
    * 参数一：数据源
    * 参数二：目的地
    *
    * */
    /*private static void copydir(File src, File dest) throws IOException {
        dest.mkdirs();
        //递归
        //1.进入数据源
        File[] files = src.listFiles();
        //2.遍历数组
        for (File file : files) {
            if(file.isFile()){
                //3.判断文件，拷贝
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest,file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while((len = fis.read(bytes)) != -1){
                    fos.write(bytes,0,len);
                }
                fos.close();
                fis.close();
            }else {
                //4.判断文件夹，递归
                copydir(file, new File(dest,file.getName()));
            }
        }
    }*/
}
