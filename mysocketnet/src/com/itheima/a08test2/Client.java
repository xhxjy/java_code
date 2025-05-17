package com.itheima.a08test2;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：发送一条数据，接收服务端反馈的消息并打印
        //服务器：接收数据并打印，再给客户端反馈消息

        Socket socket = new Socket("127.0.0.1", 10086);

        OutputStream os = socket.getOutputStream();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要发送的语句");
        String str = sc.nextLine();
        os.write(str.getBytes());

        //写出一个结束标记
        socket.shutdownOutput();

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        socket.close();



































        /*//1.创建Socket对象并连接服务端
        Socket socket = new Socket("127.0.0.1",10000);


        //2.写出数据
        String str = "见到你很高兴！";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        //写出一个结束标记
        socket.shutdownOutput();


        //3.接收服务端回写的数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b = isr.read()) != -1){
            System.out.print((char)b);
        }


        //释放资源
        socket.close();*/


    }
}