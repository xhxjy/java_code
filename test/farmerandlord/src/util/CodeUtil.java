package util;

import java.util.Random;

public class CodeUtil {

    public static String getCode(){
        //获取52个大小写字母
        char[] arr=new char[52];
        for (int i = 0; i < arr.length; i++) {
            if(i<26){
                arr[i]=(char)(97+i);
            }else{
                arr[i]=(char)(65+i-26);
            }
        }

        //随机获取4个大小写字母,用字符串将它们拼接起来,最后再拼接数字
        StringBuilder sb=new StringBuilder();
        Random r=new Random();

        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(arr.length);
            sb.append(arr[randomIndex]);
        }
        int number = r.nextInt(10);
        sb.append(number);

        //将字符串打乱
        // 将字符串转为字符数组
        char[] code = sb.toString().toCharArray();
        for (int i = 0; i < code.length; i++) {
            //每循环一次,该字符与随机的索引进行交换
            int randomIndex = r.nextInt(code.length);
            char temp=code[randomIndex];
            code[randomIndex]=code[i];
            code[i]=temp;
        }
        //将数组转为字符串,不可用code.tostring方法因为得到的是字符串的地址值
        //根据字符数组的值来创建一个新的字符串
        return new String(code);
    }
}