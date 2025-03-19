package test_3_18;

import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        //创建集合
        ArrayList<String> list=new ArrayList<>();
        //添加
        list.add("xjy");
        list.add("xhn");
        list.add("1314");

        //删除
//        list.remove("xhn");
        //查询
//        String str= list.get(0);
//        System.out.println(str);
//        //修改
//        String s = list.set(1, "zqg");
//        System.out.println(s);
//        System.out.println(list);
        //遍历
        for (int i = 0; i < list.size(); i++) {
            String str= list.get(i);
            System.out.println(str);
        }
    }
}
