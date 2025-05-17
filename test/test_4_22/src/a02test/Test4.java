package a02test;

import java.io.File;

public class Test4 {
    public static void main(String[] args) {
        /*
           需求3:删除一个多级文件夹
        */
        File f = new File("D:\\aaa\\bbb");
        deleteDir(f);
        System.out.println("xhn");
    }

    //删除一个文件夹
    //1.删除一个文件夹里的所有内容
    //2.删除空的文件夹
    public static void deleteDir(File f) {
        //先删除文件夹里面的所有内容
        //里面的内容可能包括:文件夹和文件
        for (File file : f.listFiles()) {
            //文件,直接删除
            if(file.isFile()){
                file.delete();
            } else if (file.isDirectory()) {
                //文件夹,递归本方法
                //删除里面的内容,再将文件夹本身删除
                deleteDir(file);
            }
        }
        //将空的文件夹删除
        f.delete();
    }

































    //        File file = new File("D:\\aaa\\src");
//        delete(file);

    /*
    * 作用：删除src文件夹
    * 参数：要删除的文件夹
    * */
    /*public static void delete(File src){
        //1.先删除文件夹里面所有的内容
        //进入src
        File[] files = src.listFiles();
        //遍历
        for (File file : files) {
            //判断,如果是文件，删除
            if(file.isFile()){
                file.delete();
            }else {
                //判断,如果是文件夹，就递归
                delete(file);
            }
        }
        //2.再删除自己
        src.delete();
    }*/


}
