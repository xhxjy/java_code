package a01mystream;

import java.util.HashMap;

public class StreamDemo3 {
    public static void main(String[] args) {
        //双列集合      无                                                   无法直接使用stream流

        HashMap<String,Integer> hs=new HashMap<>();
        hs.put("a",1);
        hs.put("b",2);
        hs.put("c",3);
        hs.entrySet().stream().forEach(entry ->
                System.out.println(entry.getKey()+","+entry.getValue()) );
        hs.keySet().stream().forEach(k-> System.out.println(k+","+hs.get(k)));
























        /*//1.创建双列集合
        HashMap<String,Integer> hm = new HashMap<>();
        //2.添加数据
        hm.put("aaa",111);
        hm.put("bbb",222);
        hm.put("ccc",333);
        hm.put("ddd",444);

        //3.第一种获取stream流
        //hm.keySet().stream().forEach(s -> System.out.println(s));

        //4.第二种获取stream流
        hm.entrySet().stream().forEach(s-> System.out.println(s));*/
    }
}
