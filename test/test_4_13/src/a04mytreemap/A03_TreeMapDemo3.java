package a04mytreemap;

import java.util.TreeMap;

public class A03_TreeMapDemo3 {
    public static void main(String[] args) {
       /*
        需求：
        字符串“aababcabcdabcde”
        请统计字符串中每一个字符出现的次数，并按照以下格式输出
        输出结果：
        a（5）b（4）c（3）d（2）e（1）
        */

        //1.创建treemap集合
        TreeMap<Character,Integer> tm=new TreeMap<>();

        String str="aababcabcdabcde";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //存在
            if(tm.containsKey(c)){
                //取得该字符当前的次数并++
                Integer count = tm.get(c);
                count++;
                //将修改的次数重新添加进map集合中
                tm.put(c,count);
            }
            //不存在
            else{
                tm.put(c,1);
            }
        }

//        System.out.println(tm);

        //按照固定格式输出
        //a（5）b（4）c（3）d（2）e（1）
        //法1
        //遍历修改输出格式
//        tm.forEach(( c,count)-> System.out.print(c+" ("+count+") "));

        //法2
        //其中需要拼接字符串,可以用到StringBuilder来提高拼接效率
        StringBuilder sb=new StringBuilder();
        tm.forEach(( c,count)-> sb.append(c).append(" (").append(count).append(") "));

        System.out.println(sb);

        //法3
        //
















        /*//1.定义字符串
        String s = "aababcabcdabcde";

        //2.创建集合
        TreeMap<Character,Integer> tm = new TreeMap<>();

        //3.遍历字符串得到里面的每一个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //拿着c到集合中判断是否存在
            //存在，表示当前字符又出现了一次
            //不存在，表示当前字符是第一次出现
            if(tm.containsKey(c)){
                //存在
                //先把已经出现的次数拿出来
                int count = tm.get(c);
                //当前字符又出现了一次
                count++;
                //把自增之后的结果再添加到集合当中
                tm.put(c,count);
            }else{
                //不存在
                tm.put(c,1);
            }
        }

        //4.遍历集合，并按照指定的格式进行拼接
        // a（5）b（4）c（3）d（2）e（1）
        //StringBuilder sb = new StringBuilder();
        //tm.forEach((key, value)->sb.append(key).append("(").append(value).append(")"));

        StringJoiner sj = new StringJoiner("","","");
        tm.forEach((key, value)->sj.add(key + "").add("(").add(value + "").add(")"));

        System.out.println(sj);*/


    }
}
