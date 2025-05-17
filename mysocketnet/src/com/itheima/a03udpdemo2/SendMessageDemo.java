package com.itheima.a03udpdemo2;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
         /*
            按照下面的要求实现程序
                UDP发送数据：数据来自于键盘录入，直到输入的数据是886，发送数据结束
                UDP接收数据：因为接收端不知道发送端什么时候停止发送，故采用死循环接收
        */
        //发送数据

        //1.创建对象
        DatagramSocket ds=new DatagramSocket();
        //这两个信息是固定的
        //发送的ip地址
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //设置要发送的端口
        int port=10086;

        Scanner sc=new Scanner(System.in);
        while (true) {
            //2.打包数据
            //用键盘录入要发送的数据
            System.out.print("请输入你要说的话:");
            String str = sc.nextLine();
            byte[] bytes = str.getBytes();
            //打包数据
            DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length, address, port);
            //3.发送数据
            ds.send(dp);
            //判断对话是否结束(说完这句话就结束)
            if("886".equals(str)){
                break;
            }
        }
        //释放资源
        ds.close();

































       /* //1.创建对象DatagramSocket的对象
        DatagramSocket ds = new DatagramSocket();

        //2.打包数据
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您要说的话：");
            String str = sc.nextLine();
            if("886".equals(str)){
                break;
            }
            byte[] bytes = str.getBytes();
            InetAddress address = InetAddress.getByName("255.255.255.255");
            int port = 10086;
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
            //3.发送数据
            ds.send(dp);
        }


        //4.释放资源
        ds.close();*/


    }
}
