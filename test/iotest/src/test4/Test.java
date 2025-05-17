package test4;

import cn.hutool.core.io.FileUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的姓名，每一个姓名占一行。
            要求通过程序实现随机点名器。
            第三次必定是张三同学

          运行效果：
            第一次运行程序：随机同学姓名1
            第二次运行程序：随机同学姓名2
            第三次运行程序：张三
            …
        */

        //D:\java_code\test\iotest\src\test4\count.txt
        //读取文件数据,获取次数并加1
        FileInputStream fis = new FileInputStream("iotest\\src\\test4\\count.txt");
        int count = fis.read();
        count++;
        fis.close();
        //将修改后的次数写入文件
        FileOutputStream fos = new FileOutputStream("iotest\\src\\test4\\count.txt");
        fos.write(count);
        fos.close();
        List<String> allNamesList = FileUtil.readLines("D:\\java_code\\test\\iotest\\src\\test3\\allnames.txt", "UTF-8");
        //读取出来的count是对应次数的ASCII码值,所以需要对其(或对比的次数)进行强转,然后再进行判断
        if (count == (int)'3') {
            System.out.println("张三");
        } else {
            Collections.shuffle(allNamesList);
            String[] info = allNamesList.getFirst().split("-");
            System.out.println(info[0]);
        }
    }
}
