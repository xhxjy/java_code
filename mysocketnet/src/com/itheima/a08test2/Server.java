package com.itheima.a08test2;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：发送一条数据，接收服务端反馈的消息并打印
        //服务器：接收数据并打印，再给客户端反馈消息

        ServerSocket ss = new ServerSocket(10086);
        Socket socket = ss.accept();

        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] chars = new char[1024];
        int len;
        while ((len=br.read(chars))!=-1){
            System.out.print(new String(chars,0,len));
        }

        OutputStream os = socket.getOutputStream();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要发送的语句");
        String str = sc.nextLine();
        os.write(str.getBytes());

        socket.close();
        ss.close();


/*InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }*/





























        /*//1.创建对象并绑定10000端口
        ServerSocket ss = new ServerSocket(10000);

        //2.等待客户端连接
        Socket socket = ss.accept();

        //3.socket中获取输入流读取数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        //细节：
        //read方法会从连接通道中读取数据
        //但是，需要有一个结束标记，此处的循环才会停止
        //否则，程序就会一直停在read方法这里，等待读取下面的数据
        while ((b = isr.read()) != -1){
            System.out.println((char)b);
        }

        //4.回写数据
        String str = "到底有多开心？";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        //释放资源
        socket.close();
        ss.close();*/


    }
}