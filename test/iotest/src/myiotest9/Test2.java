package myiotest9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) throws IOException {
        /*

              Properties跟IO流结合的操作

        */

        Properties prop=new Properties();

        prop.put("jks","jdk");
        prop.put("aaa","jdk");
        prop.put("bbb","vvv");

        FileWriter fw = new FileWriter("D:\\java_code\\test\\iotest\\c.properties");
        prop.store(fw,"test");
        fw.close();






























        /*//1.创建集合
        Properties prop = new Properties();

        //2.添加数据
        prop.put("aaa","bbb");
        prop.put("bbb","ccc");
        prop.put("ddd","eee");
        prop.put("fff","iii");

        //3.把集合中的数据以键值对的形式写到本地文件当中
        FileOutputStream fos = new FileOutputStream("myiotest\\a.properties");
        prop.store(fos,"test");
        fos.close();*/


        /*BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest\\a.properties"));
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            bw.write(key + "=" + value);
            bw.newLine();
        }
        bw.close();*/




    }
}
