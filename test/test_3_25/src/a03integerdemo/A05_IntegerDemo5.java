package a03integerdemo;

import java.util.Scanner;

public class A05_IntegerDemo5 {
    public static void main(String[] args) {
        //更改键盘录入的方式
        //原来的方式有可能会无法得到空格或制表符后的信息
        Scanner sc=new Scanner(System.in);
        //无论要录入什么类型的数据,都先写为字符串,后面通过对应的包装类调用方法来转换为对应类型
        String string=sc.nextLine();
//        System.out.println(string);

//        int i = Integer.parseInt(string);
//        System.out.println(i+1);

        double v = Double.parseDouble(string);
        System.out.println(v+1);
//public static Integer valueOf(String s)  返回保存指定String值的 Integer 对象
//static string tobinarystring(int i)      得到二进制
//static string tooctalstring(int i)       得到八进制
//static string toHexstring(int i)         得到十六进制
//static int parseInt(string s)            将字符串类型的整数转成int类型的整数




//        //键盘录入
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个字符串");
//        /* String str = sc.next();
//        System.out.println(str);*/
//        //弊端:
//        //当我们在使用next，nextInt，nextDouble在接收数据的时候，遇到空格，回车，制表符的时候就停止了
//        //键盘录入的是123 123 那么此时只能接收到空格前面的数据
//        //我想要的是接收一整行数据
//        //约定:
//        //以后我们如果想要键盘录入，不管什么类型，统一使用nextLine
//        //特点:遇到回车才停止
//        String line = sc.nextLine();
//        System.out.println(line);
//        double v = Double.parseDouble(line);
//        System.out.println(v);
    }
}
