package search;

import java.util.ArrayList;

public class A01_BasicSearchDemo2 {
    public static void main(String[] args) {
        //课堂练习2：
        //需求：定义一个方法利用基本查找，查询某个元素在数组中的索引
        //要求：需要考虑数组中元素有重复的可能性
        //{131, 127, 147, 81, 103, 23, 7, 79, 81}
        //我要查找81，想要返回的是所有索引 3 8
        int[] arr={131, 127, 147, 81, 103, 23, 7, 79, 81};
        int num=81;
        ArrayList<Integer> list = search(arr, num);
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
        }else{
            System.out.println("不存在");
        }
    }
    //技巧:若我们需要返回多个数据的话,我们可以将这些数据放到一个容器中,如数组和集合;最后将容器1返回即可
    public static ArrayList<Integer> search(int[] arr,int num){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(num==arr[i]){
                list.add(i);
            }
        }
        return list;
    }


}
