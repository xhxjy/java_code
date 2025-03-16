package excise3;

import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        //1.生成中奖号码
        int[] prizeArr = creatNum();
        for (int i = 0; i < prizeArr.length; i++) {
            System.out.print(prizeArr[i] + " ");
        }
        //2.用户输入号码
        int[] userArr = inPutNum();
        for (int i = 0; i < userArr.length; i++) {
            System.out.print(userArr[i] + " ");
        }
        //3.判断用户的中奖情况
        //判断红球和篮球各自的中奖个数
        //判断红球中奖个数
        int redCount = getCount(prizeArr, userArr);
        System.out.println(redCount);
        //判断篮球中奖个数
        int blueCount = 0;
        if (prizeArr[prizeArr.length - 1] == userArr[userArr.length - 1]) {
            blueCount++;
        }
        //结合上述的中奖个数给出结果
        if (redCount >= 0 && redCount <= 2 && blueCount == 1) {
            System.out.println("恭喜你中了5元");
        } else if (((redCount == 3 || redCount == 4) && blueCount == 1)
                || redCount == 4 && blueCount == 0) {
            System.out.println("恭喜你中了10元");
        }
//        else if () {
//
//        }
    }

    //1.生成中奖号码
    public static int[] creatNum() {
        //创建一个数组用于添加中奖号码
        int[] arr = new int[7];
        //生成中奖号码:6个红色,1个蓝色
        Random r = new Random();
        //红色(不能重复)
        int i = 0;
        for (i = 0; i < 6; ) {
            int redNum = r.nextInt(33) + 1;
            //判断号码是否在arr数组中是否重复
            boolean flag = contain(arr, redNum);
            //不重复
            if (!flag) {
                arr[i] = redNum;
                //需要生成6个不重复的号码(理解这个语句放在这里的含义)
                //输入一个有效号码才算完成一个有效的循环
                i++;
            }
        }
        //蓝色
        int blueNum = r.nextInt(16) + 1;
        arr[i] = blueNum;
        return arr;
    }

    //判断号码在数组中是否存在
    public static boolean contain(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return true;
            }
        }
        return false;
    }

    //2.用户输入号码
    public static int[] inPutNum() {
        //创建一个数组用于添加号码
        int[] arr = new int[7];
        //输入6个红球号码,且对6个号码进行判断不重复,并将它们添加进数组中
        //号码需要进行两种判断:合法性和唯一性
        Scanner sc = new Scanner(System.in);
        int i = 0;//下面的蓝球号码需要用到i
        for (i = 0; i < 6; ) {
            System.out.println("请输入你的第" + (i + 1) + "个红球号码(1~33):");
            int redNum = sc.nextInt();
            //判断号码是否合法
            if (redNum >= 1 && redNum <= 33) {
                //判断号码是否在arr数组中是否重复
                boolean flag = contain(arr, redNum);
                //不重复
                if (!flag) {
                    arr[i] = redNum;
                    i++;
                }
                //重复,给出提示
                else {
                    System.out.println("号码重复,重新输入!");
                }
            } else {
                System.out.println("号码不合法,请重新输入");
            }
        }
        //输入1个篮球号码
        System.out.println("请输入你的蓝球号码(1~16):");
        int blueNum = sc.nextInt();
        while (true) {
            //判断号码是否合法
            //合法
            if (blueNum >= 1 && blueNum <= 16) {
                arr[i] = blueNum;//上面的循环结束后,i==6,刚好符合要求;也可以写为arr.length-1
                break;
            }
            //            不合法
            else {
                System.out.println("号码不合法,请重新输入");
            }
        }
        return arr;
    }

    //判断红球中奖个数(两个数组对比相同的元素个数,只要有相同的即可,没必要位置一样)
    public static int getCount(int[] prizeArr, int[] userArr) {
        int count = 0;//记录中奖个数
        for (int i = 0; i < userArr.length - 1; i++) {//只判断红球的数组长度要-1
            for (int j = 0; j < prizeArr.length; j++) {
                if (prizeArr[i] == userArr[i]) {
                    count++;
                    break;//若在中奖号码中找到相同的元素,就跳出当前循环
                }
            }
        }
        return count;
    }
}
