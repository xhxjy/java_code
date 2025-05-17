package mycharset;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharSetDemo3 {
    public static void main(String[] args) throws UnsupportedEncodingException {
       /*
       Java中编码的方法
            public byte[] getBytes()                        使用默认方式进行编码
            public byte[] getBytes(String charsetName)      使用指定方式进行编码

        Java中解码的方法
            String(byte[] bytes)                            使用默认方式进行解码
            String(byte[] bytes, String charsetName)        使用指定方式进行解码
        */


        //编码
        String str1="喜欢hjy";
        byte[] bytes1 = str1.getBytes();
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = str1.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));


        //解码
        String s = new String(bytes1);
        System.out.println(s);

        String s1 = new String(bytes2,"GBK");
        System.out.println(s1);



























       /*//1.编码
        String str = "ai你哟";
        byte[] bytes1 = str.getBytes();
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));


        //2.解码
        String str2 = new String(bytes1);
        System.out.println(str2);

        String str3 = new String(bytes1,"GBK");
        System.out.println(str3);*/

    }
}