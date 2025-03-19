package test_3_18;

import java.util.Random;
import java.util.Scanner;

public class StringDemo1 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        Random r=new Random();
        //打乱数据
        for (int i = 0; i < arr.length; i++) {
            int index=r.nextInt(arr.length);
            //两个数交换
            char temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
        String result=new String(arr);
        System.out.println(result);
    }
}
