package a04mygenerics;


import java.util.ArrayList;

/*
    定义一个工具类：ListUtil
    类中定义一个静态方法addAll，用来添加多个集合的元素。
*/
public class GenericsDemo3 {

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();

        ListUtil.addAll(list,2,3,6);
        System.out.println(list.toString());
    }






























    /*public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        ListUtil.addAll(list1, "aaa", "bbb", "ccc", "ddd");
        System.out.println(list1);


        ArrayList<Integer> list2 = new ArrayList<>();
        ListUtil.addAll(list2,1,2,3,4);
        System.out.println(list2);

    }*/
}
