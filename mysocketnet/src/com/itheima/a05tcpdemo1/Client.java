package com.itheima.a05tcpdemo1;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //TCP协议，发送数据

        //1.创建Socket对象
        //细节:创建对象的同时会连接服务器,若连接不上会报错(所以要先开启服务器,再开启客户端)
        Socket socket = new Socket("127.0.0.1", 10086);
        //2.从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();
        //3.写出数据
        os.write("你好呀".getBytes());
        //4.释放资源
        os.close();//输出流可关,可不关.因为只要连接通道关闭了,这个输出流也过不去,相当于关闭了(服务器的输入流同理)
        socket.close();





























        /*//1.创建Socket对象
        //细节：在创建对象的同时会连接服务端
        //      如果连接不上，代码会报错
        Socket socket = new Socket("127.0.0.1",10000);


        //2.可以从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();
        //写出数据
        os.write("aaa".getBytes());

        //3.释放资源
        os.close();
        socket.close();*/


    }
}
