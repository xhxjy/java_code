package myconvertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
            将本地文件中的GBK文件，转成UTF-8
        */
        //相当于文件拷贝,只不过编码不同而已

        //这个方式和下面的fw效果一样,所以说利用转换流按照指定字符编码读写在jdk11以后已经被下面的方法
        //OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("D:\\aaa\\jkn.txt"),
        //        Charset.forName("UTF-8"));
        //1.以gbk编码读取,以UTF-8编码写入
        FileReader fr=new FileReader("D:\\aaa\\gbkfile.txt", Charset.forName("GBK"));
        FileWriter fw=new FileWriter("D:\\aaa\\jkn.txt",Charset.forName("UTF-8"));
        int c;
        while (-1 != (c = fr.read())){
            fw.write(c);
        }
        fw.close();
        fr.close();






































        //1.JDK11以前的方案
       /* InputStreamReader isr = new InputStreamReader(new FileInputStream("myio\\b.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myio\\d.txt"),"UTF-8");

        int b;
        while((b = isr.read()) != -1){
            osw.write(b);
        }

        osw.close();
        isr.close();*/

        /*//2.替代方案
        FileReader fr = new FileReader("myio\\b.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("myio\\e.txt",Charset.forName("UTF-8"));
        int b;
        while ((b = fr.read()) != -1){
            fw.write(b);
        }
        fw.close();
        fr.close();*/


    }
}
