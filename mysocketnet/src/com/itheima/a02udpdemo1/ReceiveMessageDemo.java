package com.itheima.a02udpdemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        //接收数据

        //1.创建DatagramSocket对象(快递公司)
        //细节:需要手动指定端口(与发送消息的端口一致)
        DatagramSocket ds=new DatagramSocket(10086);

        //2.接收数据
        //自己创建一个数组接收
        byte[] bytes = new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes, bytes.length);
        //该方法是阻塞的,若一直接收不到数据,程序会在这里死等
        System.out.println(1111);
        ds.receive(dp);
        System.out.println(2222);

        //3.解析数据(根据数据包来解析,所以调用者是数据包,即dp;而不是ds)
        byte[] data = dp.getData();
        int len = dp.getLength();
        int port = dp.getPort();
        InetAddress address = dp.getAddress();
        System.out.println("接收数据:"+new String(data,0,len));
        System.out.println("该数据是由"+address+"电脑的"+port+"端口发送的");

        //4.释放资源
        ds.close();




































        /*//1.创建DatagramSocket对象（快递公司）
        //细节：
        //在接收的时候，一定要绑定端口
        //而且绑定的端口一定要跟发送的端口保持一致
        DatagramSocket ds = new DatagramSocket(10086);


        //2.接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);


        //该方法是阻塞的
        //程序执行到这一步的时候，会在这里死等
        //等发送端发送消息
        System.out.println(11111);
        ds.receive(dp);
        System.out.println(2222);


        //3.解析数据包
        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println("接收到数据" + new String(data,0,len));
        System.out.println("该数据是从" + address + "这台电脑中的" + port + "这个端口发出的");

        //4.释放资源
        ds.close();*/


    }
}
