package com.itheima.a07test1;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：多次发送数据
        //服务器：接收多次接收数据，并打印

        Socket socket = new Socket("127.0.0.1",10086);
        //通过连接通道只要创建一次输入/输出流就可以
        OutputStream os = socket.getOutputStream();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("请输入你要发送的信息:");
            String str = sc.nextLine();
            os.write(str.getBytes());
            if("886".equals(str)) break;
        }

        socket.close();

























       /* //1. 创建Socket对象并连接服务端
        Socket socket = new Socket("127.0.0.1",10000);

        //2.写出数据
        Scanner sc = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();


        while (true) {
            System.out.println("请输入您要发送的信息");
            String str = sc.nextLine();
            if("886".equals(str)){
                break;
            }
            os.write(str.getBytes());
        }


        //3.释放资源
        socket.close();*/


    }
}
