package mybytestream2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
        *   练习：
        *       文件拷贝
        *       把D:\itheima\movie.mp4拷贝到当前模块下。
        *
        *   注意：
        *       选择一个比较小的文件，不要太大。大文件拷贝我们下一个视频会说。
        *
        *
        *
        *   课堂练习：
        *       要求统计一下拷贝时间，单位毫秒
        * */

        long start = System.currentTimeMillis();
        //思路:先将目标文件读取的程序中,将读取到的数据写入到该模块中(边读边写)

        //先将目标文件读取的程序中
        //创建字节输入流的对象
        FileInputStream fis=new FileInputStream(new File("D:\\cache.db"));
        //将读取到的数据写入到该模块中
        //创建字节输出流的对象
        FileOutputStream fos=new FileOutputStream(new File("test_4_22\\jkl.db"));

        //边读边写
        int b;
        while ((b=fis.read())!=-1){
            fos.write(b);
        }

        //规则:先开后关(先开的流后关)
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println(end-start);


































//        long start = System.currentTimeMillis();

        /*//1.创建对象
        FileInputStream fis = new FileInputStream("D:\\itheima\\movie.mp4");
        FileOutputStream fos = new FileOutputStream("myio\\copy.mp4");
        //2.拷贝
        //核心思想：边读边写
        int b;
        while((b = fis.read()) != -1){
            fos.write(b);
        }
        //3.释放资源
        //规则：先开的最后关闭
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);*/

    }
}
