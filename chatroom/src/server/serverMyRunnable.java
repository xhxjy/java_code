package server;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

//该线程的任务:对客户端的用户信息进行检验
public class serverMyRunnable implements Runnable {
    Socket socket;
    Properties prop;

    public serverMyRunnable(Socket socket, Properties prop) {
        this.socket = socket;
        this.prop = prop;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //第一次读取的是当前执行的操作
            String choice = br.readLine();
            switch (choice) {
                case "login" -> login(br, prop);
                case "register" -> register(br, prop);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //注册
    private void register(BufferedReader br, Properties prop) throws IOException {
        System.out.println("注册操作");
        //第二次读取的是用户信息
        String userinfo = br.readLine();
        //对用户信息进行判断
        //获取用户信息的用户名和密码
        String[] split = userinfo.split("&");
        String username = split[0].split("=")[1];
        String password = split[1].split("=")[1];
        if (prop.containsKey(username)){
            //用户名重复
            //发状态码
            sendMessage2Client("4");
        }else if(!judgeUsername(username)){
            //用户名不合法
            sendMessage2Client("5");
        }else if(!judgePassword(password)){
            //密码不合法
            sendMessage2Client("6");
        }else{
            //注册成功,将用户信息写入本地文件,开始聊天
            sendMessage2Client("7");
            //打印注册者的消息
            System.out.println("注册成功,用户名为"+username+",密码为"+password);
            //将成功注册的socket对象添加进对应的集合中
            Server.list.add(socket);
            //将注册的用户信息写入本地文件夹
            //细节:需要打开续写开关,否则会将之前的用户信息清空
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream("D:\\java_code\\chatroom\\usersInfo.txt",true)));
            bw.write(userinfo);
            bw.newLine();
            bw.flush();
            //开始聊天
            //接收客户端发送的消息
            talk2All(br, username);
        }
    }

    private boolean judgePassword(String password) {
        //长度3~8
        if(password.length()<3||password.length()>8){
            return false;
        }
        //第一位必须是大小写字母
        char c = password.charAt(0);
        if(c<'A'||c>'z'||(c>'Z'&&c<'a')){
            return false;
        }
        //除了第一位后面全是数字
        for (int i = 1; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(ch<'0'||ch>'9'){
                return false;
            }
        }
        return true;
    }

    private boolean judgeUsername(String username) {
        //长度
        if(username.length()<6||username.length()>18){
            return false;
        }
        //纯字母
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if(c<'A'||c>'z'||(c>'Z'&&c<'a')){
                return false;
            }
        }
        return true;
    }

    //获取用户登录时传递过来的信息,并进行校验
    //参数一:输入流
    //参数二:本地的用户信息
    private void login(BufferedReader br, Properties prop) throws IOException {
        System.out.println("登录操作");
        //第二次读取的是用户信息
        String userinfo = br.readLine();
        //对用户信息进行判断
        //获取用户信息的用户名和密码
        String[] split = userinfo.split("&");
        String username = split[0].split("=")[1];
        String password = split[1].split("=")[1];
        if (prop.containsKey(username)) {
            //用户名存在
            String rightPassword = (String) prop.get(username);
            if (rightPassword.equals(password)) {
                //登陆成功
                //打印登录者的信息
                System.out.println("登陆成功,用户名为"+username+",密码为"+password);
                //将成功登录的socket对象添加进对应的集合中
                Server.list.add(socket);
                //细节:写对应的状态码
                sendMessage2Client("1");
                //开始聊天
                //接收客户端发送的消息
                talk2All(br, username);
            } else {
                //密码有误
                sendMessage2Client("2");
            }
        } else {
            //用户名不存在
            sendMessage2Client("3");
        }
    }

    private void talk2All(BufferedReader br, String username) throws IOException {
        System.out.println("说话操作");
        //读取客户端的人要说的话
        while (true) {
            String words = br.readLine();
            System.out.println(username + "发过来消息:" + words);

            //遍历客户端集合,将说的话进行群发
            for (Socket s : Server.list) {
                //s表示每一个客户端对象
                sendMessage2Client(s,username + "发过来消息:" + words);
            }
        }
    }

    //将说的话进行群发,就是对每一个客户端发消息
    private void sendMessage2Client(Socket s, String message) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write(message);
        bw.newLine();
        bw.flush();
    }

    //写反馈信息给客户端
    //参数:反馈信息
    private void sendMessage2Client(String message) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(message);
        bw.newLine();
        bw.flush();
    }

}
