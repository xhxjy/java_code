package a04test;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        /*
            自己实现parseInt方法的效果，将字符串形式的数据转成整数。要求:
            字符串中只能是数字不能有其他字符,最少一位，最多10位,0不能开头
        */
        //键盘录入字符串
        Scanner sc=new Scanner(System.in);
        String line = null;
        while (true) {
            line = sc.nextLine();
            //用正则表达式解决对字符串的判断
            String regex="[1-9]\\d{0,9}";
            if(!line.matches(regex)){
                System.out.println("字符串不符合要求,请重新输入");
                continue;
            }
            System.out.println(stringToNum(line));
            break;
        }
    }

    private static int stringToNum(String line) {
        int sum=0;
        for (int i = 0; i < line.length(); i++) {
            //将字符转为整型
            char c = line.charAt(i);
            int num=c-'0';
            //将字符串的各个数字字符逐个转化为整数里的各个数字
            sum=sum*10+num;
    //算法原理:在10进制中,整数数字从右到左,其对应的权重会上升;如:123--->1*10*10+2*10+3*1(10的0次方)
        }
        return sum;
    }
}