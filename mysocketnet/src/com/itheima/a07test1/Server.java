package com.itheima.a07test1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：多次发送数据
        //服务器：接收多次接收数据，并打印

        ServerSocket ss = new ServerSocket(10086);

        Socket socket = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
//细节:只要客户端不断开连接,它与服务器的连接通道里的输入/出流就不会断,服务器会一直读取流里的数据即服务端会一直卡在br.read()处.
        // 因为只要客户端断开连接,
        // 对应的连接通道会被关闭,而通道中的输入和输出流也会关闭,从而导致br.read()==-1,跳出循环,最后结束服务器
        //相当于客户端在输入信息(还未断开连接)时,服务器一直在该循环中接收并打印数据
        //简单来说:只有客户端关闭,服务器才会关闭,所以服务器无需靠循环来接收并读取数据
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

        //关闭连接通道和服务器
        socket.close();
        ss.close();

























        /*//1.创建对象绑定10000端口
        ServerSocket ss = new ServerSocket(10000);

        //2.等待客户端来连接
        Socket socket = ss.accept();

        //3.读取数据
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1){
            System.out.print((char)b);
        }




        //4.释放资源
        socket.close();
        ss.close();*/


    }
}
