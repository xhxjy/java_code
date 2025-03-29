package ui;
import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        char[] arr=new char[52];
        //将大小写字母赋值给数组
        for (int i = 0; i < arr.length; i++) {
            if(i<26){
                arr[i]=(char)(97+i);
            } else{
                arr[i]=(char)(65+i-26);
            }
        }
        Random r=new Random();
        //需要进行多次拼接,创建对象
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randomIndex=r.nextInt(arr.length);
            sb.append(arr[randomIndex]);
        }
        int num = r.nextInt(10);
        sb.append(num);

        char[] result = sb.toString().toCharArray();
        for (int i = 0; i < result.length; i++) {
            int randomIndex=r.nextInt(result.length);
            char temp=result[i];
            result[i]=result[randomIndex];
            result[randomIndex]=temp;
        }
        return sb.toString();
    }
}
