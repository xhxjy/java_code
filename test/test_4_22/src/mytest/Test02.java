package mytest;

import java.io.*;

public class Test02 {
    public static void main(String[] args) throws IOException {
        /*
            为了保证文件的安全性，就需要对原始文件进行加密存储，再使用的时候再对其进行解密处理。
            加密原理：
                对原始文件中的每一个字节数据进行更改，然后将更改以后的数据存储到新的文件中。
            解密原理：
                读取加密之后的文件，按照加密的规则反向操作，变成原始文件。


             ^ : 异或
                 两边相同：false
                 两边不同：true

                 0：false
                 1：true

                 如:100^10:
               100:1100100
               10: 1010

               1100100
             ^ 0001010
             __________
               1101110
             ^ 0001010
             __________
               1100100

        */

        /*为了保证文件的安全性，就需要对原始文件进行加密存储，再使用的时候再对其进行解密处理。
    加密原理：
    对原始文件中的每一个字节数据进行更改，然后将更改以后的数据存储到新的文件中。
    解密原理：
    读取加密之后的文件，按照加密的规则反向操作，变成原始文件。*/
        //加密:拷贝文件并将里面的每一个字节数据改变(不可用字节数组)
        //加密方法:将读取的字节数据随便异或一个数字
        //解密方法:将异或的结果再与原来的那个数字异或,就可以得到最初的数字即字节数据
        //核心:^:异或(下面是它的运算原理)
        /*^ : 异或
        两边相同：false
        两边不同：true

        0：false
        1：true

        如:100^10:
        100:1100100
        10: 1010

        1100100
                ^ 0001010
        __________
        1101110
                ^ 0001010
        __________
        1100100*/
        FileInputStream fis = new FileInputStream("test_4_22\\a.txt");
        FileOutputStream fos = new FileOutputStream("test_4_22\\b.txt");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b ^ 10);
        }
        fos.close();
        fis.close();
    }































    /*public static void encryptionAndReduction(File src, File dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b ^ 2);
        }
        //4.释放资源
        fos.close();
        fis.close();
    }
*/

}
