package a02test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test6Case2 {

    public static void main(String[] args) {
       /*
            需求5：统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
            打印格式如下：
            txt:3个
            doc:4个
            jpg:6个
        */
        File f = new File("D:\\aaa");
        HashMap<String, Integer> hm = print(f);
        hm.forEach((name,count)-> System.out.println(name +","+count));
    }
    //方法:
    //用计数器思想不方便
    //直接返回一个map集合(键:文件类型,值:个数)

    public static HashMap<String, Integer> print(File f) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (File file : f.listFiles()) {
            if (file.isFile()) {
                //考虑到文件名有很多情况:a.txt,a.a.a.txt,aaa
                //所以要规定
                // 1.它切割后的数组长度>=2;
                //2.取数组最后一个元素为后缀名

                //该正则表达式是为了表示"."这个字符,因为'.'在正则表达式中属于特殊字符,
                // 需要用'\'这个转义字符来转义为正常的字符'.',可以理解为"\."=="."
                //而'\'它是转义字符,也需要一个'\'来转义

                //简单理解:"\\"=="\"(两个==一个)
                String[] arr = file.getName().split("\\.");
                if (arr.length >= 2) {
                    String name = arr[arr.length - 1];
                    if (hm.containsKey(name)) {
//                    Integer count = hm.get(name);
//                    count++;
//                    hm.put(name,count);
                        hm.put(name, hm.get(name) + 1);
                    } else {
                        hm.put(name, 1);
                    }
                }
            } else if (file.isDirectory()) {
                HashMap<String, Integer> sonMap = print(file);
                //将子文件夹中的键和值加入父文件夹中
                Set<Map.Entry<String, Integer>> entries = sonMap.entrySet();
                //遍历子文件夹,判断父文件夹中是否有子文件夹的键,若有则两者出现的次数相加
                //若无则将子文件夹的键和值添加进去
                for (Map.Entry<String, Integer> entry : entries) {
                    String name = entry.getKey();
                    Integer count = entry.getValue();
                    if (hm.containsKey(name)) {
                        hm.put(name, hm.get(name) + count);
                    } else {
                        hm.put(name, count);
                    }
                }
            }
        }
        return hm;
    }
}