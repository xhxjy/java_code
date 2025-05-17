package com.itheima.a09test3;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器。接收服务器的反馈。
        //服务器：接收客户端上传的文件，上传完毕之后给出反馈。

        ServerSocket ss = new ServerSocket(10086);
        Socket socket = ss.accept();

        //边读边写
        BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
        //写出的文件名重复,用
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\java_code\\mysocketnet\\serverdir\\"+name+".jpg"));
        byte[] bytes = new byte[1024*1024*5];
        int len;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();

        //写给客户端的反馈
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String str="服务器上传成功";
        bw.write(str);
        bw.newLine();
        bw.flush();//强制发送缓冲区数据(用bw写入时,写完内容后必须加上这句话),否则写入的内容不会显示

        socket.close();
        ss.close();



























        /*//1.创建对象并绑定端口
        ServerSocket ss = new ServerSocket(10000);

        //2.等待客户端来连接
        Socket socket = ss.accept();

        //3.读取数据并保存到本地文件中
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("mysocketnet\\serverdir\\a.jpg"));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        bos.close();
        //4.回写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        //5.释放资源
        socket.close();
        ss.close();*/
    }
}