package a02test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test1 {
    public static void main(String[] args) {
       /*
        定义一个集合，并添加一些整数  1,2,3,4,5,6,7,8,9,10
        过滤奇数，只留下偶数。
        并将结果保存起来
       */


        ArrayList<Integer> list=new ArrayList<>();

        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);
        Integer[] arr = list.stream()
                .filter(s -> s % 2 == 0)
                .toArray(value -> new Integer[value]);

        System.out.println(Arrays.toString(arr));




























       /* //1. 定义一个集合
        ArrayList<Integer> list = new ArrayList<>();
        //2.添加一些整数
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //3.过滤奇数，只留下偶数
        //进行判断，如果是偶数，返回true 保留
        List<Integer> newList = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        //4.打印集合
        System.out.println(newList);*/
    }

}