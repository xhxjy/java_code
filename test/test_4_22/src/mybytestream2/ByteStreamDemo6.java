package mybytestream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo6 {
    public static void main(String[] args) throws IOException {
        /*
         *   练习：
         *       文件拷贝
         *       把D:\itheima\movie.mp4 (16.8 MB) 拷贝到当前模块下。
         *
         * */


        long start = System.currentTimeMillis();
        //先读取再写入
        FileInputStream fis=new FileInputStream("D:\\cache.db");
        FileOutputStream fos=new FileOutputStream(("test_4_22\\copy.db"));

        //创建字节数组
        byte[] bytes = new byte[1024*1024*5];//1mb
        int b;
        while ((b=fis.read(bytes))!=-1){
            fos.write(bytes,0,b);
        }

        //释放资源
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();
        System.out.println(end-start);
































        /*long start = System.currentTimeMillis();

        //1.创建对象
        FileInputStream fis = new FileInputStream("D:\\itheima\\movie.mp4");
        FileOutputStream fos = new FileOutputStream("myio\\copy.mp4");
        //2.拷贝
        int len;
        byte[] bytes = new byte[1024 * 1024 * 5];
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        //3.释放资源
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);*/


    }
}
