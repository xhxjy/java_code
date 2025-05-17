package com.itheima.myiotest9;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test3 {
    public static void main(String[] args) throws IOException {

        //读取配置文件的信息
        //1.创建集合
        Properties prop = new Properties();
        //2.读取本地Properties文件里面的数据
        FileInputStream fis = new FileInputStream("myiotest\\a.properties");
        prop.load(fis);
        fis.close();
        //3.打印集合
        System.out.println(prop);
    }
}
