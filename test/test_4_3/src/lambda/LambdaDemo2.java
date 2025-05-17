package lambda;

import java.util.Arrays;

public class LambdaDemo2 {
    public static void main(String[] args) {
        String[] arr={"xh1314","9402","xhn","xhxjy"};
        //当我们要让数组中的数据进行一定顺序的排列时,就用sort方法
        Arrays.sort(arr, (o1,o2)-> o1.length()-o2.length());
        //打印数组
        System.out.println(Arrays.toString(arr));
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }*/
    }
}
