package com.itheima.a11test5;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyThread extends Thread{
    Socket socket;

    public MyThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        synchronized (MyThread.class){
            try {
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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
