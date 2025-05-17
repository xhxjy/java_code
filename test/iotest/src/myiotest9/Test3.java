package myiotest9;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Test3 {
    public static void main(String[] args) throws IOException {


        Properties prop=new Properties();

        FileReader fr = new FileReader("iotest\\c.properties");
        prop.load(fr);
        //要记得关流
        fr.close();
        //并未简洁到哪去
        /*prop.load(new FileReader("iotest\\c.properties"));
        new FileReader("iotest\\c.properties").close();*/

        System.out.println(prop);



































        /*//1.创建集合
        Properties prop = new Properties();
        //2.读取本地Properties文件里面的数据
        FileInputStream fis = new FileInputStream("myiotest\\a.properties");
        prop.load(fis);
        fis.close();

        //3.打印集合
        System.out.println(prop);*/
    }
}
