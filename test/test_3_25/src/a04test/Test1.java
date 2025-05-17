package a04test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        /*
            键盘录入一些1~100之间的整数，并添加到集合中。直到集合中所有数据和超过200为止。
        */

        //创建一个整数包装类的集合
        ArrayList<Integer> list = new ArrayList<>();
        //用while循环累加即可
        //键盘录入
        int i = 0;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        while (sum <= 200) {
            System.out.println("请输入一个整数(1~100)");
            String line = sc.nextLine();
            int num = Integer.parseInt(line);
            //判断数据合法性
            //直接先将非法数据进行过滤(判断)
            if (num < 1 || num > 100) {
                System.out.println("数据非法,请重新输入");
                continue;
            }
            //代码走到这时,表明数据是合法的
            sum += num;
            //将录入的数据添加进集合
            list.add(num);
        }
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j) + " ");
        }
    }
}
