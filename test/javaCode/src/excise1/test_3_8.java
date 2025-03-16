package excise1;

//import java.util.Scanner;
//
//public class test_3_8 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("请输入机票原价:");
//        double price = sc.nextInt();
//        System.out.print("请输入当前月份:");
//        int month = sc.nextInt();
////设立缓冲区(为什么此时无需缓冲区?)C语言中使用scanf接收键盘录入时才需要;java的键盘录入方式不需要
////        int a = 0;
////        while ((a = getchar()) != '\n')
////        {
////            ;
////        }
//        System.out.print("请输入您的舱类(头等舱输入a,经济舱输入b):");
//        char choice=sc.next().charAt(0);
//        //计算票价的地方,代码重复过多,,可将它们写为一个方法
//        if(month>=5&&month<=10)
//            if(choice=='a')
//                price*=0.9;
//            else
//                price*=0.85;
//        else
//        if(choice=='a')
//            price*=0.7;
//        else
//            price*=0.65;
//        System.out.println("实际价格为:"+price);
//    }
//    //判断票价的方法
//    //思路
//    //1.我要干什么:根据舱位和相应的折扣来计算相应的票价(代码块)
//    //2.干这件事,我需要什么才能完成:原价,舱位,头等舱的折扣,经济舱的折扣(参数)
//    //3.方法的调用处是否需要方法的返回值:要返回实际票价(返回类型)

import java.util.Scanner;

////    public static int getTicket(int price,char choice,double v0,double v1) {
////        if(choice=='a')
////            price*=v0;
////        else
////            price*=v1;
////        return price;
////    }
//}
//判断素数
//public class test_3_8 {
//    public static void main(String[] args) {
//        for(int i=100;i<=200;i++){
//            if(isPrime(i))//与c语言不同的是,不能返回1/0,来作为判断式的结果表真假;用boolean类型最合适
//                System.out.print(i+" ");//用这种方式输出方便查看
//        }
//    }
//    public static boolean isPrime(int n) {
//        for (int i = 2; i < n; i++) {
//            if(n%i==0)
//                return false;
//        }
//        return true;
//    }
//}

//开发验证码
//public class test_3_8 {
//    public static void main(String[] args) {
//        //定义一个字符串类型的变量,来记录最终结果
//        String result = "";//创建一个空的字符串,方便后面拼接
//        //1.将大写和小写字母都放到数组中
//        char[] arr=new char[52];
//        char ch1='a';
//        char ch2='A';
//        for (int i = 0; i < arr.length; i++) {
//            if(i<26){
//                arr[i]=ch1;//也可以将ch1换为(char)(97+i),下面的ch2换为(char)(65+i-26),这个方法不会创建变量从而占用内存
//                ch1++;
//            }
//            else{
//                arr[i]=ch2;
//                ch2++;
//            }
//        }
//        //2.随机抽取4次
//        Random r = new Random();
//        for (int i = 0; i < 4; i++) {
//            int randomIndex = r.nextInt(arr.length);
//            result+=arr[randomIndex];//字符串的拼接
//        }
//        //3.随机抽1个数字
//        int num = r.nextInt(10);
//        System.out.println(result+num);//打印最终结果
//    }
//
//}
//将大小写字母放到数组中的原因是:
//方法:当我们要对一堆无规律的数据中随机抽取时,可以将它们放在数组中(因为数组是有序排列的),然后随机抽取索引

//太过冗长,可以分成几个方法写
public class test_3_8 {
    public static void main(String[] args) {
        //1.输入六个分数并存入数组
        int[] arr=new int[6];
        arr=getScore(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
//        //2.要定义两个对应的索引,找到最高和最低分,并将它们都赋为0
//        int max=arr[0];
//        int min=arr[0];
//        int maxIndex=0;
//        int minIndex=0;
//        for (int i = 1; i < arr.length; i++) {
//            if(max<arr[i]){
//                max=arr[i];
//                maxIndex=i;
//            }
//            if(min>arr[i]){
//                min=arr[i];
//                minIndex=i;
//            }
//        }
//        arr[maxIndex]=0;
//        arr[minIndex]=0;
        //2.求最大值,并将最大值赋值为0
        //3.求最小值,并将最小值赋值为0

//        //3.计算数组和,求平均值
//        int sum=0;
//        for (int i = 0; i < arr.length; i++){
//            sum+=arr[i];
//        }
//        System.out.println(sum/(arr.length-2));
    }

    public static int[] getScore(int[] arr1) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr1.length; i++)
            arr1[i]=sc.nextInt();
        return arr1;
    }
}