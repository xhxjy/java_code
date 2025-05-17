package mybytestream1;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
            换行写：
                再次写出一个换行符就可以了
                windows： \r\n
                Linux:    \n
                Mac:      \r
            细节：
                在windows操作系统当中，java对回车换行进行了优化。
                虽然完整的是\r\n，但是我们写其中一个\r或者\n，
                java也可以实现换行，因为java在底层会补全。
            建议：
                不要省略，还是写全了。


            续写：
                如果想要续写，打开续写开关即可
                开关位置：创建对象的第二个参数
                默认false：表示关闭续写，此时创建对象会清空文件
                手动传递true：表示打开续写，此时创建对象不会清空文件

        */


        //换行写
        //创建对象
        FileOutputStream fos=new FileOutputStream(new File("test_4_22\\a.txt"),true);

        //写入数据,
        // 可以先写字符串,后调用方法转为字节数组,然后写入即可
        String str1="xjyani";
        byte[] arr1 = str1.getBytes();
        fos.write(arr1);

        //在中间打印一个换行符即可
        //可以写其中一个,但推荐写全
        String str2="\r\n";
        byte[] arr2 = str2.getBytes();
        fos.write(arr2);

        String str3="520";
        byte[] arr3 = str3.getBytes();
        fos.write(arr3);

        //续写
        //在创建对象时打开续写开关即可,它是第二个参数
        //默认是false,不让续写,每次创建对象会清空文件;改为true即可

        //释放资源
        fos.close();




































        /*//1.创建对象
        FileOutputStream fos = new FileOutputStream("myio\\a.txt",true);
        //2.写出数据
        String str = "kankelaoyezuishuai";
        byte[] bytes1 = str.getBytes();
        fos.write(bytes1);

        //再次写出一个换行符就可以了
        String wrap = "\r\n";
        byte[] bytes2 = wrap.getBytes();
        fos.write(bytes2);

        String str2 = "666";
        byte[] bytes3 = str2.getBytes();
        fos.write(bytes3);

        //3.释放资源
        fos.close();*/





    }
}
