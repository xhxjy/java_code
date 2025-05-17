package a01myfile;

import java.io.File;

public class FileDemo6 {
    public static void main(String[] args) {

        //public File[] listFiles()       获取当前该路径下所有内容
        File f1 = new File("D:\\aaa");
        //获取文件夹里的所有内容并将它们放到一个文件数组中
        File[] f = f1.listFiles();
        if (f != null) {
            for (File file : f) {
                //file表示里面的文件或文件夹
                System.out.println(file);
            }
        }


























        /*//1.创建File对象
        File f = new File("D:\\aaa");
        //2.listFiles方法
        //作用：获取aaa文件夹里面的所有内容，把所有的内容放到数组中返回
        File[] files = f.listFiles();
        for (File file : files) {
            //file依次表示aaa文件夹里面的每一个文件或者文件夹
            System.out.println(file);
        }*/

    }
}
