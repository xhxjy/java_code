package test_3_18;

import java.util.Random;

public class StringDemo2 {
    public static void main(String[] args) {
        //创建一个包含26大小写字母的数组
        char[] chs=new char[52];
        //赋值大小写字母
        for (int i = 0; i < chs.length; i++) {
            if(i<26){
                chs[i]=(char)(97+i);
            }else{
                chs[i]=(char)(65-26+i);
            }
        }
        Random r=new Random();
        //随机抽取4次
        String result="";
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(chs.length);
            result+=chs[index];
        }
        int num=r.nextInt(10);
        result+=num;

        //打乱搞好的验证码
        char[] arr = result.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int index=r.nextInt(arr.length);
            char temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
        String str=new String(arr);
        System.out.println(str);
    }
}
