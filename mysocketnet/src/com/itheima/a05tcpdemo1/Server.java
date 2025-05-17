package com.itheima.a05tcpdemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //TCP协议，接收数据

        //1.创建ServerSocket
        ServerSocket ss=new ServerSocket(10086);

        //2.监听客户端的连接,若一直连不上客户端,代码会一直卡在这里
        Socket socket = ss.accept();

        //3.从连接通道中获取输入流来读取数据
        //用字节流读取容易造成乱码,需要将它转为字符流,最后再用缓冲流包装一下,提高读取效率
        BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
        while ((b=br.read())!=-1){
            System.out.print((char) b);
        }
        //4.释放资源
        br.close();
        socket.close();
        ss.close();






































        /*//1.创建对象ServerSocker
        ServerSocket ss = new ServerSocket(10000);

        //2.监听客户端的链接
        Socket socket = ss.accept();

        //3.从连接通道中获取输入流读取数据
        InputStream is = socket.getInputStream();
        int b;
        while ((b = is.read()) != -1){
            System.out.println((char) b);
        }

        //4.释放资源
        socket.close();
        ss.close();*/

    }
}
