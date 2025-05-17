package server;

import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

public class Server {
    //创建存储客户端的集合
    static ArrayList<Socket> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //创建ServerSocket对象
        ServerSocket ss = new ServerSocket(10086);
        //1.获取本地的用户信息
        Properties prop=new Properties();
        FileReader fr=new FileReader("D:\\java_code\\chatroom\\usersInfo.txt");
        prop.load(fr);
        fr.close();
        //2.对客户端的用户信息进行检验
        //考虑到可能有多个客户端在同时进行登录操作,所以只要来了一个客户端,就开一条线程处理
        while (true){
//不可写在循环外面,否则后来的客户端需要等前面的客户端完成操作后才能进行相应的操作.达不成多线程的效果
            //等待客户端的连接
            Socket socket = ss.accept();
            System.out.println("有客户端来连接");
            //对客户端的用户信息进行检验,需要两个参数(线程的)
            //参数一:客户端
            //参数二:本地的用户信息
            new Thread(new serverMyRunnable(socket,prop)).start();
        }
    }
}
