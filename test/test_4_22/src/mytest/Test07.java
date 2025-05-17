package mytest;

import java.io.*;

public class Test07 {
    public static void main(String[] args) throws IOException {
            /*
                实现一个验证程序运行次数的小程序，要求如下：
                1.当程序运行超过3次时给出提示:本软件只能免费使用3次,欢迎您注册会员后继续使用~
                2.程序运行演示如下:
                    第一次运行控制台输出: 欢迎使用本软件,第1次使用免费~
                    第二次运行控制台输出: 欢迎使用本软件,第2次使用免费~
                    第三次运行控制台输出: 欢迎使用本软件,第3次使用免费~
                    第四次及之后运行控制台输出:本软件只能免费使用3次,欢迎您注册会员后继续使用~
           */

        //将程序运行的次数写在文件中,相比直接在程序中用count计数,在每次程序运行完时将会重新变为0(在内存中)

        //不可将bw写在此处,因为该文件存在,从而会将文件清空,导致后面读取不了数据
        //IO流的书写原则:随用随写,不用关闭
        BufferedReader br=new BufferedReader(new FileReader("test_4_22\\a.txt"));
//        BufferedWriter bw=new BufferedWriter(new FileWriter("test_4_22\\a.txt"));

        //1.获取程序运行次数
        int count = Integer.parseInt(br.readLine());
        br.close();
        //2.更改运行次数
        //程序又运行了一次
        count++;

        //3.根据运行次数给出提示
        if(count<=3){
            System.out.println("第"+count+"次使用");
        }else{
            System.out.println("不可使用");
        }

        //4.将改变的次数写在文件中
        BufferedWriter bw=new BufferedWriter(new FileWriter("test_4_22\\a.txt"));
        bw.write(count+"");
        bw.close();

































        /*//1.把文件中的数字读取到内存中
        //原则：
        //IO：随用随创建
        //    什么时候不用什么时候关闭
        BufferedReader br = new BufferedReader(new FileReader("myio\\count.txt"));
        String line = br.readLine();
        br.close();

        System.out.println(line);//null
        int count = Integer.parseInt(line);
        //表示当前软件又运行了一次
        count++;//1
        //2.判断
        if(count <= 3){
            System.out.println("欢迎使用本软件,第"+count+"次使用免费~");
        }else{
            System.out.println("本软件只能免费使用3次,欢迎您注册会员后继续使用~");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\count.txt"));
        //3.把当前自增之后的count写出到文件当中
        bw.write(count + ""); //97 + ""
        bw.close();*/


    }
}
