package regexdemo;

import java.util.Scanner;

public class RegexDemo1 {
    public static void main(String[] args) {
        System.out.println("请输入一个qq号");
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
//        if(isQQ(str)){
//            System.out.println("qq号合法");
//        }else{
//            System.out.println("qq号不合法");
//        }
        System.out.println(str.matches("[1-9]\\d{5,19}"));
    }

    private static boolean isQQ(String string) {
        //技巧:先将异常的情况进行判断,利用了程序是由上到下依此执行的,所以程序走到最后都满足了条件
        if(string.length()<6||string.length()>20){
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(c>'9'||c<'0')
                return false;
        }
        return !string.startsWith("0");
    }
}
