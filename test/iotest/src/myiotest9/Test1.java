package myiotest9;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
         /*

              Properties作为Map集合的操作

        */
        //
        Properties prop=new Properties();

        //细节:虽然Properties无泛型,但是我们一般添加字符串类型数据
        prop.put("jks","jdk");
        prop.put("aaa","jdk");
        prop.put("bbb","vvv");

        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"="+value);
        }


































        /*//1.创建集合的对象
        Properties prop = new Properties();

        //2.添加数据
        //细节：虽然我们可以往Properties当中添加任意的数据类型，但是一般只会往里面添加字符串类型的数据
        prop.put("aaa","111");
        prop.put("bbb","222");
        prop.put("ccc","333");
        prop.put("ddd","444");*/

        //3.遍历集合
        /*Set<Object> keys = prop.keySet();
        for (Object key : keys) {
            Object value = prop.get(key);
            System.out.println(key + "=" + value);
        }*/

       /* Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "=" + value);
        }*/

    }
}