package a04test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        /*

            定义一个方法自己实现toBinaryString方法的效果，将一个十进制整数转成字符串表示的二进制

         */
        Scanner sc= new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(toBinary(num));
        System.out.println(Integer.toBinaryString(num));
    }
    public static String toBinary(int num){
        //转换进制的方法:取余除基法
        //不断地模以2(基数)获得余数,后面再除以2(不可调换顺序,否则得到的余数将会少一位)
        StringBuilder sb=new StringBuilder();
        while (true){
            if(num==0){
                break;
            }
            int remainder = num % 2;
            //将余数反向拼接
            sb.insert(0,remainder);//0:表示将余数都放到字符串的首位,即0索引的位置
            num/=2;
        }
        return sb.toString();
    }

}
