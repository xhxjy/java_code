package excise3;

import java.util.Random;

public class Draw {
    public static void main(String[] args) {
        //最优解,效率高
//        //思路1.
//        //打乱数组,在打乱的数组中抽取奖品
//        int[] prize={2,588,888,1000,10000};
//        //遍历数组
//        for (int i = 0; i < prize.length; i++) {
//            随机数组索引
//            Random c=new Random();
//            int randomIndex=c.nextInt(prize.length);
//            交换元素
//            int temp=prize[i];
//            prize[i]=prize[randomIndex];
//            prize[randomIndex]=temp;
//        }
//        for (int i = 0; i < prize.length; i++) {
//            System.out.println(prize[i]);
//        }
        //直接遍历即可
//        for (int i = 0; i < prize.length; i++) {
//            System.out.println(prize[i]);
//        }


//循环次数过多效率低下
//思路2
//定义一个新数组存储抽奖的结果
//抽奖:在原数组中随机数组索引,判断抽奖的结果在新数组中是否存在,若不存在则i++并将其添加进新数组中;
// 若存在,则继续循环抽奖(不用管),
        int[] prize={2,588,888,1000,10000};
        //定义一个新数组存储抽奖的结果
        int[] prizeResult=new int[prize.length];
        //进行抽奖
        for (int i = 0; i < prize.length;) {
//            随机数组索引
            Random c=new Random();
            int randomIndex=c.nextInt(prize.length);
            //判断抽奖的结果在新数组中是否存在(contain方法)
            int result=prize[randomIndex];
            boolean flag = contain(prizeResult, result);
            //不存在
            if(!flag){
                prizeResult[i]=result;
                i++;
            }
        }
        //
        for (int i = 0; i < prizeResult.length; i++) {
            System.out.println(prizeResult[i]);
        }
    }

    //        判断抽奖的结果在新数组中是否存在
    public static boolean contain(int[] arr,int prize){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==prize){
                return true;//存在
            }
        }
        //不存在
        return false;
    }
}
